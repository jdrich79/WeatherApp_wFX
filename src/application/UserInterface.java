package application;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private JSONInputOutput jIO = new JSONInputOutput();
    private CallWUAPI callWU = new CallWUAPI();
    private CallNWSAPI callNWS = new CallNWSAPI();
    private DailyForecast dailyForecast = new DailyForecast();
    private ASCIIArt art = new ASCIIArt();
    //private location loc = new location();
    
 
    /**
     * Displays a welcome message to the user.
     */
    public void welcome() {
        System.out.println("Welcome to the Weather-matic 3000!\n\n");
        
        art.asciiArt("Weather-");
        System.out.println();
        art.asciiArt("      matic");
        System.out.println("\n");
        art.asciiArt("          3000");
        System.out.println();
        
        System.out.println("\nThis application will provide you weather forecasts"
                + " for multiple locations, \rfrom multiple weather services.\n");
        
        System.out.println("You can maintain a 'Location List' of your favorite places "
                + "and get a single \rweather forecast report for all your locations in one report.\n");
        
        // Pauses to allow welcome be displayed for a set amount of time before initial instructions.
        // TODO - do we want to try to clear the console?
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    
    /**
     * Helper method to take in ArrayList and pretty print a numbered list 
     * @param list (ArrayList) - List to be pretty printed and put in Hashmap
     */
    public void prettyPrintList(ArrayList<String> list) {
        int num = 1;
        for (int i = 0; i < list.size(); i++) {
            String file = list.get(i);
            System.out.println(num + ". " + file);
            num++;
        }

    }
    
    /**
     * Helper method to take in ArrayList and put that number list into a HashMap
     * @param list (ArrayList) - List to be pretty printed and put in Hashmap
     * @return (HashMap) - Numbered list in a HashMap
     */
    public HashMap<Integer, String> hashMapLocList(ArrayList<String> list) {
        HashMap<Integer, String> pPrtList = new HashMap<Integer, String>();
        int num = 1;
        for (int i = 0; i < list.size(); i++) {
            String file = list.get(i);
            //System.out.println(num + ". " + file);
            pPrtList.put(num, file);
            num++;
        }
        
        return pPrtList;
    }
 
    /**
     * Helper method to take in an 'int' and return a list from 1 to int
     * in a String array
     * @param potentialListSize (int) - value for String array 1 to 'int'
     * @return (String[])
     */
    public String numString(int potentialListSize) {
        String[] numOptions = new String[potentialListSize];
        Integer num = 1;
        for (int i = 0; i < potentialListSize; i++) {
            numOptions[i] = num.toString();
            num++;
                 
        }
        String numsList = Arrays.toString(numOptions);
        // System.out.println(numsList);
        return numsList;
    }
    
    
    /**
     * Prompts the user to select if they would like to use an existing 'Location List',
     * create a new list, or edit an existing list.
     * 
     * While Loop used to continue prompting until a valid response it provided.
     */
    public void selection() {
        ArrayList<String> files = jIO.getFiles(); // gets a list of potential files that could be Location Lists (.json)
        int numOfExistingFiles = files.size(); // checks the list of the ArrayList
        HashMap<Integer, String> locList = this.hashMapLocList(files); // creates a numbered Hashmap of Location List files
        // If there are no .json files in the SavedSearches sub-folder, goes right to creating a new list
        if (numOfExistingFiles == 0) {
            System.out.println("\nIt doesn't look like there are any saved Location Lists in the current directory.\n"
                    + "Let's start a new Location List!");
            
            System.out.println("\n\n\n\n**If you believe you have a saved Location Lists, please check that this "
                    + "\napplication and the Locations lists are located in the same directory structure.");
            
            /// GO TO createNewList 
            // ******************************** Temporary ********************************
            
            System.out.println("This part is still under contruction! "
                    + "\nIf you see this, please add the .json files to a sub-fold named: Saved Searches");
            art.asciiArt("Not yet!");

         // ******************************** Temporary ********************************
            
        }
        /*
         *  If there are potential location lists, a pretty print list is presented along with the option
         *  to create a new list or edit an existing list.
         */
        else {
            // creating a String to become options for user input, either (1) or (1-n), n = size of ArrayList
            
            String listNums = "";
            if (numOfExistingFiles == 1) {
                listNums = "(1)";
            } else {listNums = "(1-" + numOfExistingFiles + ")";}

            System.out.println("It looks like you might have some saved Location List!"); 
            this.prettyPrintList(files);

            System.out.println("\nWould you like to get a forecast report for one of the existing Location List files?"
                    + "\nYou can also: 'N' Create a new list, or 'E' Edit an existing list.");

            System.out.print("\nTo use an existing list, enter the corresponding number " + listNums + ", "
                    + "\n'N' for a new list, or 'E' to edit an existing: ");
        }

        // Using the 'numString' helper method, this take is the number of existing files found in the 
        // working directory and creates a String list of 1 to n --> n = num of files found. ex. [1, 2, 3, 4]
        String fileNumsList = this.numString(numOfExistingFiles); 
        
        scan = new Scanner(System.in);
        String initSelection = scan.next();

        int validCheck = 0; // Variable used to continue looping until valid response received.
        
        while (validCheck == 0) {
            // checks if user input a number that corresponds to the listed files.
            if(fileNumsList.contains(initSelection)) {
                int numSelection = Integer.parseInt(initSelection); // converts num from String to int
                String selectedFile = locList.get(numSelection); // gets the file name from the 'locList' HashMap
                System.out.println(System.lineSeparator().repeat(50)); // poor-man screen clear
                System.out.println("\nYou selected --> " + numSelection + ". " + selectedFile);
                
                
                this.useExistingList(selectedFile);
                
                validCheck = 1;
                               
                
            } else if (initSelection.toLowerCase().equals("n")) {
                System.out.println("\nSelected 'N' for New");
                
                // GO TO: create new Location List method
                this.createNewList();
                
                // ******************************** Temporary ********************************
                
//                System.out.println("\n This part is still under contruction! Select a List. Bye now!!");
//                art.asciiArt("Not yet!");
                
                
             // ******************************** Temporary ********************************
                
                validCheck = 1; // switched to '1' to exit while loop
                
                

            } else if (initSelection.toLowerCase().equals("e")) {
                System.out.println("Selected 'E' for Edit");
                
                
                // GO TO: edit existing Location List method
                
                // ******************************** Temporary ********************************
                
                System.out.println("This part is still under contruction!");
                art.asciiArt("Not yet!");

             // ******************************** Temporary ********************************
                validCheck = 1; // switched to '1' to exit while loop
                
            } else {
                
                /*
                 * If a valid response is not received, the value of 'validCheck' 
                 * remains 0, and the While Loop continues to loop until a 
                 * valid response is received 
                 */
                System.out.println("\nThat is not a valid selection. Please try again!!");
                System.out.print("Enter the number corresponding to an existing 'Location List', "
                        + "\n'N' to create a new list, or 'E' to edit your list: ");
                initSelection = scan.next();
            }
            // TEST PRINT
            //System.out.println("\n\n**Out of While Loop!!**");
        }
    }
    
    public ArrayList<String> selectedFileLocationList (String filename) {
        ArrayList<String> locationList = new ArrayList<String>();
        ArrayList<Location> locsArray = jIO.fileReader(filename);
        for (Location location : locsArray) {
            locationList.add(location.getDisplayName());
        }
        return locationList;
        
    }
    
    /**
     * Method to handle when user input is to use an existing Location List. <br>
     * Runs each of the locations within the selected Location List json, through both APIs. <br>
     * Prints out the location and a general narrative of the forecast for each day.
     * @param filename (String) - filename of json file contain Location List
     * @return (HashMap) - Key = Location with prefix <br>  Key prefixes: WU_ - WeatherUndergroud & NWS_ - National Weather Service <p>
     * Value = ArrayList of DailyForecast - for the location and weather service indicated by Key
     */
    public HashMap<String, ArrayList<DailyForecast>> useExistingList(String filename) {
        ArrayList<Location> locsArray = jIO.fileReader(filename);
        System.out.println("\n\nLet's get the forecasts for your locations in <" + filename + ">\n");

        // Create HashMap to store the multiple location forecasts from WUnderground.
        // For the first weather service, a message is displayed to show the locations and coordinates
        HashMap<String, ArrayList<DailyForecast>> forecastsHMap = new HashMap<String, ArrayList<DailyForecast>>();
        
        // Iterates through each location in the Location List and runs it through each API.
        // Each location is surrounded (top & bottom) by a row of stars
        // For each location the weather service is named with a  starred row
        int num = 1;
        for (Location location : locsArray) {
            System.out.print("**************************************************************************************");
            System.out.println("\nLocation #" + num + ": " + location.getDisplayName());
            System.out.println("At a latitude/longitude of " + location.getLatitude() + "/" + location.getLongitude());
            System.out.println("**************************************************************************************\n");
            
            // Both API calls have been set to take in a String parameter of comma separated latitude and longitude. Ex. "39.717,-104.9"
            String latLong = location.getLatitude() + "," + location.getLongitude(); // puts latitude and longitude into String
            
            // WEATHERUNDERGROUND FORECAST 
                // This part handles calling the WUnderground API for each of the location and displaying a narrative.
                // Try/Catch used to handle if API call fails for any reason. Prints out a message indicated there was issue with call.
            try {
                // WEATHERUNDERGROUND
                System.out.println("*************** WUnderground ***************");
                String jsonRecd = callWU.makeAPICall(latLong);
                String key = "WU_" + location.getDisplayName();
                ArrayList<DailyForecast> value = callWU.parse5DayJSON(jsonRecd);

                forecastsHMap.put(key, value);

                // PRINTS NARRATIVE
                for (int i = 0; i < value.size(); i++) {
                    dailyForecast.weatherNarrative(value.get(i)); 
                }

            } catch (IOException e) {
                System.out.println("There was an issue calling the WUnderground forecast for <" + location.getDisplayName() + ">.");
                //e.printStackTrace();
            }


            // NATIONAL WEATHER SERVICE
            System.out.println("*************** National Weather Service ***************");
            String key2 = "NWS_" + location.getDisplayName();
            ArrayList<DailyForecast> value2 = callNWS.getNWSForecast(latLong);

            if (value2 == null) {
                System.out.println("There was an issue calling the National Weather Service forecast for <" + location.getDisplayName() + ">.");
            } else {

                forecastsHMap.put(key2, value2);

                // PRINTS NARRATIVE
                for (int i = 0; i < value2.size(); i++) {
                    dailyForecast.weatherNarrative(value2.get(i));  
                }

            }

            num++;

        }
        return forecastsHMap;

    }


    
    /**
     * Method to handle when user input is to create a new Location List
     */
    public ArrayList<Location> createNewList() {
        Scanner scanner = new Scanner(System.in);
        String filename;
        String userInput = "";
        ArrayList<Location> locations = new ArrayList<Location>();
        Location tempLocation = new Location();
        System.out.println("What location would you like to get the weather for?");
        while (locations.size() < 3) {
        	userInput = scanner.nextLine();
        	if (userInput.toLowerCase().contentEquals("d")) {
        		break;
        	}
        	tempLocation = getLocation(userInput);
        	if (tempLocation != null) {
        		locations.add(tempLocation);
        	}
        	if (locations.size() == 3) {
        		break;
        	}
        	System.out.println("Enter another location to get the weather for or press D to stop adding locations");
        }
        
        System.out.println("Would you like to save this list for a future search? Y/N");
        if (scanner.nextLine().toLowerCase().contentEquals("y")) {
        	System.out.println("Enter the name this search should be saved as: ");
        	filename = scanner.nextLine();
        	jIO.fileWriter(locations, filename+".json");
        }
        return locations;
        
    }
    
    /**
     * Method to allow user to input an existing list. The input is the filename of the list to 
     * be edited and this method handles displaying the contents of the list and having the user
     * select which location(s) in the list to replace one at a time. Once the user is done editing the list,
     * this method writes it back to the file.
     */
    public void editList(String filename) {
    	
    	ArrayList<Location> editLocation = jIO.fileReader(filename);
    	Scanner s = new Scanner(System.in);	
    	String useriInput = "";
    	
    	while (!useriInput.toLowerCase().contentEquals("n")) {
    		Location newLocation = null;
    		System.out.println("Which location would you like to edit? Press N to exit");
    		for (int i = 0; i < editLocation.size(); i++) {
    			System.out.println(i+1 + ". " + editLocation.get(i).getDisplayName());
    		}

    		useriInput = s.nextLine();

    		try {
    			int choice = Integer.parseInt(useriInput);
    			if (choice < editLocation.size()+1) {
    				while(newLocation == null) {
    					System.out.println("What location would you like to replace " + editLocation.get(choice-1).getDisplayName() + " with?");
    					useriInput = s.nextLine();
    					newLocation = getLocation(useriInput);

    				}

    				editLocation.remove(choice-1);
    				editLocation.add(newLocation);
    			}
    			else {
    				System.out.println("Input out of range!");
    			}
    		} catch (NumberFormatException e) {
    			if (!useriInput.toLowerCase().contentEquals("n")) {
    				System.out.println("Not a valid input! Please enter a number");
    			}
    		}
    		
    	}
        jIO.fileWriter(editLocation, filename);

    }
    
    /**
     * Method that is used to get a Location object based on a user input
     * describing a physical location they would like to get the information for.
     * User input is passed in as text and a call is made to get the GPS coordinates for 
     * the users input and also to handle the case where there are multiple possible matches for 
     * where the user was looking
     * @param input
     * @return
     */
    public Location getLocation(String input) {
    	Location tempLocation = new Location();
    	Scanner scanstring = new Scanner(System.in);
    	String newInput;
    	int choice2 = 0;
    	
    	/*
    	 * Makes a call to get the list of candidates for the users input. If there is
    	 * only 1 match for the location or none of the returns match where the user wanted to look, 
    	 * gives the user an option to try a different selection and returns null.
    	 */
    	HashMap<Integer, String> candidates = tempLocation.getLocationCandidates(input);
    	while (candidates == null) {
    		newInput = scanstring.nextLine();
    		candidates = tempLocation.getLocationCandidates(newInput);
    		if (candidates == null) {
    			System.out.println("That location could not be found, please select another.");
    		}
    	}
    	
    	/*
    	 * if there are more than 1 location candidate, prompt the user to select
    	 * which candidate they want to get the weather for
    	 */
    	if (candidates.size() > 1) {
    		System.out.println("There were a few options for that location, which one would you like?");
        	for (Integer key : candidates.keySet()) {
        		System.out.println(key + ". " + candidates.get(key));
        	}
        	System.out.println(candidates.size()+ 1 + ". Try a different search");
        	
        	
        	while (choice2 > candidates.size() || choice2 < 1) {
        		newInput = scanstring.nextLine();
        		try {
        			choice2 = Integer.parseInt(newInput);

        			if (choice2 == candidates.size()+1) {
        				return null;
        			}
        		} catch(NumberFormatException e) {
        			System.out.println("Invalid Input!");
        		}
        	}
    	}
    	/*
    	 * If there is only 1 location candidate, confirm the user wanted that one
    	 */
    	else {
    		System.out.println("You would like to get the weather for " + candidates.get(1)+ "correct? Y/N");
    		String confirm = scanstring.next();
    		if (!confirm.toLowerCase().contentEquals("y")) {
    			return null;
    		}
    		choice2 = 1;
    	}
    	tempLocation.parseAddress(choice2);
    	//scanstring.close();
    	return tempLocation;
    }
    
    /**
     * Method looks into Working Directory for files with .txt or .json
     * files. Print a numbered list of the those files. 
     * And creates a HashMap of the files. 
     * <p>
     * Key = number in list <br>
     * Value = filename
     * @return HashMap with numbered filenames
     */
    public HashMap<Integer, String> filesInDir() {
        Path currentPath = Paths.get(""); // obtains the Working Directory
        String s = currentPath.toAbsolutePath().toString(); // converts Working Directory to string
        System.out.println("Within the location <" + s + ">, "
                + "\nthe following potential 'Location List' files were found: ");

        File f = new File(s); // Instantiates the File class 
        String[] fileNames = f.list(); // .list method provides a full list of files at passed location
        
        // Creating HashMap to hold the filenames that match extensions
        HashMap<Integer, String> fileList = new HashMap<Integer, String>();
                
        int num = 1; // Used to create numbered list and the Key for HashMap
        for (int i = 0; i < fileNames.length; i++) {
            String file = fileNames[i];
            
            // Checks each file name to see if it contains the extensions
            if (file.contains(".txt") || file.contains(".json")) {
                System.out.println("   " + num + ". " + file); // prints a numbered list
                fileList.put(num, file); // add filename to HashMap
                num++;
            }
        }
        return fileList;

    }
    


}
