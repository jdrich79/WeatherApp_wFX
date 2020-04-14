package application;

public class Controller {
    UserInterface ui = new UserInterface();
    
    public void run() {

        ui.welcome(); // runs welcome messages
        ui.selection(); // runs the selection method

        //        ui.filesInDir(); // for testing .filesInDir method

        //        ui.numString(4); // for testing .numString method

        //ui.useExistingList("weather.json");

    }
}


