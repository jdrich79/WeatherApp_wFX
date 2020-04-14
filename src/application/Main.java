package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;






public class Main extends Application {
    
    JSONInputOutput jIO = new JSONInputOutput();
    private UserInterface UIBackEnd = new UserInterface();
    
    // Declaring the TextArea for Logging
    TextArea logging;
    
	@Override
	public void start(Stage primaryStage) {
	    
	    
	    try {
            //BorderPane root = new BorderPane(); // remove this line, add the one below
            Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml")); // add this line
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Weather-matic 3000");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
                      
            
            
		} catch(Exception e) {
			e.printStackTrace();
		}
        
        
        
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
