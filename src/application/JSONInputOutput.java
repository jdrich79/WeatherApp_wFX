package application;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.json.*;

/**
 * Class for importing/exporting JSON files
 * @author Bryan Rogers
 *
 */

public class JSONInputOutput {
	
	private JSONArray savedSearch = new JSONArray();
	
	/**
	 * The fileWriter method takes in an arraylist of locations
	 * and a filename and saves these files in a directory called
	 * "SavedSearches" in the current file path where this program is executing from
	 * @param locations
	 * @param filename
	 */
	public void fileWriter(ArrayList<Location> locations, String filename) {
		
		//Setup a directory called SavedSearches in the current directory if it doesn't exist
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//For the locations input, put them into a JSON object and then put that JSON object into a json array
		int i = 0;
		for (Location address : locations) {
			try {
				JSONObject jobj = new JSONObject();
			
			jobj.put("lat", address.getLatitude());
			jobj.put("longitude", address.getLongitude());
			jobj.put("locationName", address.getDisplayName());
			savedSearch.put(i, jobj);
			i++;
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
		//write the JSON to the file specified
		File f = new File(directoryPath + filename);
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(savedSearch.toString());
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The fileReader method takes in a fileName and returns
	 * an ArrayList of locations stored in the JSON file.
	 * The file imported must be in the "SavedSearches" directory
	 * in the current filepath
	 * @param filename
	 * @return
	 */
	public ArrayList<Location> fileReader(String filename){
		//Get the current directory and make a "SavedSearches" folder if it doesn't exist
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//Read in the specified file
		File f = new File(directoryPath + filename);
		String jsonText = "";
		ArrayList<Location> locations = new ArrayList<Location>();
		
		try {
			Scanner fileReader = new Scanner(f);
			while(fileReader.hasNext()) {
				jsonText += fileReader.nextLine();
			}
			
			//intake the file contents as a JSONArray and then create a location and add them to array list of locations
			JSONArray array = new JSONArray(jsonText);
			for (int i = 0; i < array.length(); i++) {
				JSONObject b = array.getJSONObject(i);
				Location l = new Location();
				l.setDisplayName(b.getString("locationName"));
				l.setLatitude(b.getString("lat"));
				l.setLongitude(b.getString("longitude"));
				
				locations.add(l);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JSONException e) {
			System.out.println("JSON exception");
		}
		return locations;
	}
	
	/**
	 * This returns an ArrayList of files from the
	 * "SavedSearches" directory in the current filepath.
	 * Logs a warning to the console if the current directory is empty and returns
	 * a blank arraylist in that case
	 * @return
	 */
	public ArrayList<String> getFiles(){
		
		//Create the savedSearches directory if it doesn't exist
		ArrayList<String> jsonFiles = new ArrayList<String>();
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//Read in all the files in the list and filter for .json files
		File f = new File(directoryPath);
		
		String[] listOfFiles = f.list();
		if (listOfFiles.length != 0) {
			for (String file : listOfFiles) {
				if (file.endsWith(".json")){
					jsonFiles.add(file);
				}
			}
		}
		if(jsonFiles.size() == 0) {
			System.out.println("Warning, no valid files in this directory!");
		}
		
		return jsonFiles;
	}
	
	/**
	 * A public class that parses the forecast for the NWS API taking in the responses of the 
	 * two pieces of forecast data APIs. Returns an arraylist of DailyForecasts for the relevant days
	 * @param forecastResponseBody
	 * @param forecastGridDataResponseBody
	 * @return
	 */
	public ArrayList<DailyForecast> parseNWSForecast(String forecastResponseBody, String forecastGridDataResponseBody){
		
		JSONObject forecastObject = new JSONObject(forecastResponseBody);
		JSONObject forecastGridDataObject = new JSONObject(forecastGridDataResponseBody);
		ArrayList<DailyForecast> weatherData = new ArrayList<DailyForecast>();
		JSONArray array = forecastObject.getJSONObject("properties").getJSONArray("periods");
		
	
		//gets forecast for each entry in the array
		for (int i = 0; i < array.length()-1; i++) {
			JSONObject b = array.getJSONObject(i);
			JSONObject c = array.getJSONObject(i+1);
			LocalDateTime startTimeOne = LocalDateTime.parse(b.getString("startTime").subSequence(0, 19));
			LocalDateTime endTimeOne = LocalDateTime.parse(b.getString("endTime").subSequence(0, 19));
			LocalDateTime startTimeTwo = LocalDateTime.parse(c.getString("startTime").subSequence(0, 19));
			LocalDateTime endTimeTwo = LocalDateTime.parse(c.getString("endTime").subSequence(0, 19));
			

			LocalDate date = startTimeOne.toLocalDate();
			LocalDate dateTwo = startTimeTwo.toLocalDate();
			
			/*for the first day or if the start date of the current object is the same as the next object
			 * create a DailyForecast object and add it to the arraylist
			 * 
			 */
			if (i == 0 || date.equals(dateTwo)) {
				//Init AM & PM variables to default values that will be "ignored" if not changed
				Integer precipProbAm = 989;
				Double precipAmountAm = 989.0;
				Integer cloudCoverAm = 989;
				String precipTypeAm = "";
				Double snowfallAm = 989.0;
				Double heatIndexAm = 989.0;
				Double windChillAm = 989.0;
				String windPhraseAm = "XX";
				String narrativeAm = "XX";
				String nameAm = "XX";
				Integer precipProbPm = 989;
				Double precipAmountPm = 989.0;
				Integer cloudCoverPm = 989;
				String precipTypePm = "";
				Double snowfallPm = 989.0;
				Double heatIndexPm = 989.0;
				Double windChillPm = 989.0;
				String windPhrasePm = "XX";
				String narrativePm = "XX";
				String namePm = "XX";

				//parses out the values needed from the gridData API
				precipProbAm = (int)Math.round(parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "probabilityOfPrecipitation", 1));
				precipAmountAm = parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "quantitativePrecipitation", 0) / 25.4;
				cloudCoverAm = (int)Math.round(parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "skyCover", 1));
				precipTypeAm = "";
				snowfallAm = (parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "snowfallAmount", 0)) / 25.4;
				heatIndexAm = (parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "heatIndex", 1) * 9.0 / 5.0) + 32;
				windChillAm = (parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "windChill", 1) * 9.0 / 5.0) + 32;
				windPhraseAm = b.getString("windDirection");
				narrativeAm = b.getString("detailedForecast");
				nameAm = b.getString("name");
				
				//checks if the 2 objects are from the same start date and if so fill out the "PM" variables
				if (date.isEqual(dateTwo)) {
					
					Double highTemp = parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeTwo, "maxTemperature", 1);
					highTemp = (highTemp * 9.0 / 5.0) + 32.0;
					Double lowTemp = (parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeTwo, "minTemperature", 1) * 9 / 5) + 32;
					
					precipProbPm = (int)Math.round(parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "probabilityOfPrecipitation", 1));
					precipAmountPm = parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "quantitativePrecipitation", 0) / 25.4;
					cloudCoverPm = (int)Math.round(parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "skyCover", 1));
					precipTypePm = "";
					snowfallPm = (parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "snowfallAmount", 0)) / 25.4;
					heatIndexPm = (parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "heatIndex", 1) * 9 / 5) + 32;
					windChillPm = (parseForecastGridData(forecastGridDataObject, startTimeTwo, endTimeTwo, "windChill", 1) * 9 / 5) + 32;
					windPhrasePm = c.getString("windDirection");
					narrativePm = c.getString("detailedForecast");
					namePm = c.getString("name");
					
					DailyForecast tempWeather = new DailyForecast("NWS", date.toString(), date.getDayOfWeek().toString(), b.getString("detailedForecast"),  
							(int)Math.round(highTemp), (int)Math.round(lowTemp), nameAm, namePm, narrativeAm, narrativePm, precipProbAm, precipProbPm, 
							cloudCoverAm, cloudCoverPm,	"XX", "XX", precipAmountAm, precipAmountPm, snowfallAm, snowfallPm, (int)Math.round(heatIndexAm), 
							(int)Math.round(heatIndexPm),(int)Math.round(windChillAm), (int)Math.round(windChillPm), windPhraseAm, windPhrasePm);
					weatherData.add(tempWeather);
					
					
				}
				/*if the dates are not equal it means we are in the first object and there is
				 * no AM forecast for the time period this was called and the DailyForecast should be setup as such
				 */
				else {
					//Typically in this case the highTemp already occurred before the start time so we should knock that back to get it 
					Double highTemp = parseForecastGridData(forecastGridDataObject, startTimeOne.minusDays(1), endTimeOne, "maxTemperature", 1);
					highTemp = (highTemp * 9.0 / 5.0) + 32.0;
					Double lowTemp = (parseForecastGridData(forecastGridDataObject, startTimeOne, endTimeOne, "minTemperature", 1) * 9.0 / 5.0) + 32;

					//call the fivedayforecast but with the "AM" values (i.e. the first object) in the PM spot
					DailyForecast tempWeather = new DailyForecast("NWS", date.toString(), date.getDayOfWeek().toString(), b.getString("detailedForecast"),
							(int)Math.round(highTemp), (int)Math.round(lowTemp), namePm, nameAm, narrativePm, narrativeAm, precipProbPm, precipProbAm, 
							cloudCoverPm, cloudCoverAm, "XX", "XX", precipAmountPm, precipAmountAm, snowfallPm, snowfallAm, (int)Math.round(heatIndexPm), 
							(int)Math.round(heatIndexAm),(int)Math.round(windChillPm), (int)Math.round(windChillAm), windPhrasePm, windPhraseAm); //25
					weatherData.add(tempWeather);

				}
		}
			
		}
		//return the weatherData arraylist
		return weatherData;
	}
	
	/**
	 * Method to parse the GPS data to return the 2 URLs at NWS
	 * meant to get the 2 full URLs for getting the complete forecast data
	 * returns an arraylist of 2 urls
	 * @param responseBody
	 * @return
	 */
	public ArrayList<String> parseGPS(String responseBody) {
		
		//sets up a list of urls as strings, and then gets those urls from the json response of the first API
		ArrayList<String> locationUrl = new ArrayList<String>();

		JSONObject object = new JSONObject(responseBody);
		locationUrl.add(object.getJSONObject("properties").getString("forecast"));
		locationUrl.add(object.getJSONObject("properties").getString("forecastGridData"));
		
		return locationUrl;
	}
	
	/**
	 * parsing function for various "keys" from the forecastDataPoints webservice
	 * this is used to get a few extra values not in the regular forecast call and 
	 * put them into a format usable in the weather object.
	 * Contains a flag to average or sum the values
	 * @param object
	 * @param startTime
	 * @param endTime
	 * @param key
	 * @return
	 */
	private Double parseForecastGridData(JSONObject object, LocalDateTime startTime, LocalDateTime endTime, String key, int avgFlag) {
		//parses out the array of values for the specified key from the input object
		JSONArray keyData = object.getJSONObject("properties").getJSONObject(key).getJSONArray("values");
		double counter = 0;
		double values = 0;
		
		//gets the dateTime of start/finish
		//LocalDateTime startDatetime = LocalDateTime.parse(startTime);
		//LocalDateTime endDatetime = LocalDateTime.parse(endTime);
		
		//for all the entries in the array, gets the values within the start/end time and adds them up
		for (int i = 0; i < keyData.length(); i++) {
			
			JSONObject o = keyData.getJSONObject(i);
			
			LocalDateTime t = LocalDateTime.parse(o.getString("validTime").subSequence(0, 16));
			if ((t.isBefore(endTime)) && (t.isAfter(startTime) || t.isEqual(startTime))) {
				
				try {
					values += o.getDouble("value");
				}
				catch (JSONException e) {
					values += 0;
				}
				counter++;
			}
		}
		
		//gets and returns the average if the flag of 1 is set
		if (avgFlag == 1) {
			double avg = values / counter;

			return avg;
		}
		return values;

	}
}
