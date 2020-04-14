package application;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.HashMap;


import org.json.JSONArray;
import org.json.JSONObject;
/**
 * A class for location storing important info about it such as
 * name, latitude, longitude
 * @author Bryan Rogers
 *
 */
public class Location {
	
	private String latitude;
	private String longitude;
	private String displayName;
	private int statusCode = 201;
	private String limit = "10";
	private JSONArray locationResponse;

	/**
	 * takes a street address as an input and makes a call to get a bunch of location candidates
	 * from locationiq.com returns a HashMap of indexes and candidates
	 * will return null if there is no location data available and prints out an error
	 * to the console in that case.
	 * Throttle at no more than 2 per second.
	 * @param address
	 * @return
	 */


	public HashMap<Integer, String> getLocationCandidates(String userInput) {
		String token = "e543fdd48f150b";
		String country = "us";
		HashMap<Integer, String> locationCandidates = new HashMap<Integer, String>();
		

			userInput = userInput.replace(" ", "+");
			String url = String.format("https://us1.locationiq.com/v1/search.php?key=%1$s&q=%2$s&format=json&countrycodes=%3$s&limit=%4$s", token, userInput, country, limit);


			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(5)).build();

			try {
				System.out.println(url);
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
				//System.out.println("response code is: " + response.statusCode());
				if (response.statusCode() > 200) {
					System.out.println("Sorry, that location cannot be found. Please enter a different location:");
					this.statusCode = response.statusCode();
					return null;

				}
				else {
					this.locationResponse = new JSONArray(response.body());
					for (int i = 0; i < locationResponse.length(); i++) {
						locationCandidates.put(i+1, locationResponse.getJSONObject(i).getString("display_name"));
					}
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//}
			return locationCandidates;
		
	}
	
	/**
	 * parses an address from an indicated location. Function takes in 
	 * the index in the HashMap returned by the getLocationCandidates()
	 * method of this class
	 * PLAN: Potentially move this to jsonIO class to keep all json Handling cohesive
	 * @param index
	 */
	public void parseAddress(int index) {
		
		JSONObject object = locationResponse.getJSONObject(index-1);
		this.latitude = object.getString("lat");
		this.longitude = object.getString("lon");
		this.displayName = object.getString("display_name");
		//this.savedLocations.put(object.toString());

	}
	
	
	public String getLatitude() {
		if (latitude.length() > 6) {
			return latitude.substring(0, 6);
		}
		return latitude;
	}
	public String getLongitude() {
		
		if (longitude.length() > 6) {
			return longitude.substring(0, 6);
		}
		return longitude;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	
	

}




