package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;


public class MainContollerFX implements Initializable {
    
    public JSONInputOutput jIO = new JSONInputOutput();
    private UserInterface UIBackEnd = new UserInterface();
    private CallWUAPI callWU = new CallWUAPI();
    private DailyForecast dailyForecast = new DailyForecast();
    private NWSWeatherWebservice callNWS = new NWSWeatherWebservice();
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
//    @FXML
//    private Button newLocsBtn;
    

    
    @FXML
    private ListView<String> jsonFileListview; // to display the list of available Location List json files
    // Sets the ObservableList as the list of Files found in SavedSearch sub-folder
    
    @FXML
    ObservableList<String> jsonFilesList = FXCollections.observableArrayList(jIO.getFiles());
    
    
    @FXML
    private ListView<String> locationsListview; // to display the locations with a selected Location List json file
    
    // Sets the ObservableList as the list of Files found in SavedSearch sub-folder
    @FXML
    ObservableList<String> locationsList = FXCollections.observableArrayList();
    
//    // Variable to hold the locations selected by the user in the 'locationsListview'
//    ArrayList<Location> localsFromSelectedJSON = new ArrayList<Location>();
    
    String userSelectedFile = "";
    

            
   
    
    /**
     * Initializes the ListView to show if there are existing files in the SavedSearch sub-folder
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // If there are existing files in the SaveSearch sub-folder, they are listed for single selection
        if (jsonFilesList.size() != 0) {
            jsonFileListview.setItems(jsonFilesList);
            jsonFileListview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 
        } 
        // If no files are found in SavedSearch sub-folder, No files found is displayed and list selection is disabled
        else {
            ObservableList<String> noContent = FXCollections.observableArrayList("No files found");
            jsonFileListview.setItems(noContent);
            jsonFileListview.setDisable(true); // disables the ListView so no selection can be made
            btn1.setDisable(true);     // disables btn1 so that is cannot be 'clicked'
        }

    }


    /**
     * ActionEvent Button that gets the user selected file from the ListView options. 
     * @param event
     * @return 
     * @return
     */
    public void Button1Action(ActionEvent event) {
        if (jsonFilesList.size() != 0) {
            String selectedFile = jsonFileListview.getSelectionModel().getSelectedItem();
            System.out.println("Selected File: " + selectedFile);
            
            // UIBackEnd.useExistingList(selectedFile);
            this.listLocationsFromFile(selectedFile);
            //return selectedFile;  

        } else {
            btn1.disableProperty();

        }
        //return null;
    }
    
    /**
     * Populates the Locations List for multiple location selection
     * Called when Button 1 selected
     * @param selectJsonFile
     * @return 
     * @return 
     */
    public void listLocationsFromFile(String selectJsonFile) {
        ObservableList<String> locationsList = FXCollections.observableArrayList(UIBackEnd.selectedFileLocationList(selectJsonFile));
        locationsListview.setItems(locationsList);
        locationsListview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        
        userSelectedFile = selectJsonFile;
        
   

    }
    
    
    public void Button2Action(ActionEvent event) {
        System.out.println("Click");
        
        List<String> selectedLocations = locationsListview.getSelectionModel().getSelectedItems();
//        for (String location : selectedLocations) {
//            System.out.println("Location: " + location);
//        }
//        System.out.println("Selected Locations: " + selectedLocations);
        
        this.locationSelection(selectedLocations);
        
    }
        
    public void locationSelection(List<String> selectedLocations) {
        
        //ArrayList<String> locationsFromFile = UIBackEnd.selectedFileLocationList(this.userSelectedFile);
        ArrayList<Location> locationsFromFile = jIO.fileReader(this.userSelectedFile);
        
//        // PRINTS Contents of both
//        for (String locInFile : locationsFromFile) {
//            System.out.println("locInFile: " + locInFile);
//        }
//        
//        for (String locSelected : selectedLocations) {
//            System.out.println("locSelected: " + locSelected);
//
//        }
        
        for (int i = 0; i < selectedLocations.size(); i++) {
            String locSelected = selectedLocations.get(i);
//            System.out.println(i + " locSelected: " + locSelected);

            for (int j = 0; j < locationsFromFile.size(); j++) {
                String locInFile = locationsFromFile.get(j).getDisplayName();
//                System.out.println(j + "locInFile: " + locInFile);    
                
                if (locInFile.equals(locSelected)) {
                    
//                    // PRINT TEST
//                    System.out.println(i + " MATCH! ");
//                    System.out.println(locInFile);
//                    System.out.println(locSelected);
//                    System.out.println();
                    
                  String latitude = locationsFromFile.get(j).getLatitude();
                  String longitude = locationsFromFile.get(j).getLongitude();
                  String locationCoordinates = latitude + "," + longitude;
//                  System.out.println(locationCoordinates);
                  
                  this.btn2HelperAPICalls(locationCoordinates);
                }
            }
        }

        
    }
        

    public void btn2HelperAPICalls(String coordinates) {
        System.out.println("*************** WUnderground ***************");
        try {
            String jsonRecd = callWU.makeAPICall(coordinates); // makes API to WUnderground
            ArrayList<DailyForecast> wUndergroundForecasts = callWU.parse5DayJSON(jsonRecd); // parse the Weather Underground JSON response string into the DailyForecast Class
            // PRINTS NARRATIVE
            for (int i = 0; i < wUndergroundForecasts.size(); i++) {
                dailyForecast.weatherNarrative(wUndergroundForecasts.get(i)); 
            }

            } catch (IOException e) {
                System.out.println("There was an issue calling the WUnderground forecast for <" + coordinates + ">.");
                e.printStackTrace();
            }
        
        
        System.out.println("*************** National Weather Service ***************");
        //String key2 = "NWS_" + location.getDisplayName();
        ArrayList<DailyForecast> NWSForecasts = callNWS.getNWSForecast(coordinates);

        if (NWSForecasts == null) {
            System.out.println("There was an issue calling the National Weather Service forecast for <" + coordinates + ">.");
        } else {

            // PRINTS NARRATIVE
            for (int i = 0; i < NWSForecasts.size(); i++) {
                dailyForecast.weatherNarrative(NWSForecasts.get(i));  
            }
        }

            
        }
        

    public void ButtonNewLocsAction(ActionEvent event) throws Exception {
        // Create a new Stage object
        Stage primaryStage = new Stage();
        // Copied from the Main_Java (boilerplate) 
        Parent root = FXMLLoader.load(getClass().getResource("/application/NewLocation.fxml")); // throw the exceptions & change .fxml name
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("New Location Setup");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    


    
    
}
