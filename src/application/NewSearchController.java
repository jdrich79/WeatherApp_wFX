package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewSearchController implements Initializable {
    private Location location = new Location();
    private UserInterface UIBackEnd = new UserInterface();

    @FXML
    private TextField searchTxtBox;
    
    @FXML
    private TextField searchLocationEntry;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
    public void searchTextBoxAction(ActionEvent entered) {
        String userSearchEntry = searchTxtBox.getText();
        System.out.println(userSearchEntry);
        UIBackEnd.getLocation(userSearchEntry); // Runs Search 
        
        // ********Results go to console*********
    }

}
