package application;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.channels.UnresolvedAddressException;
import java.time.Duration;

public class GetResponseFromURL {
	
	public static String makeRequest(String url) {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(5)).build();
		String responseBody = "";
		
		
		try {

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() > 200) {
				
				System.out.println("Help, I'm trapped in a computer! Status code is: " + response.statusCode());
				
				//handle a redirect by sending another request URL endpoint indicated in the headers
				if (response.statusCode() >= 300 && response.statusCode() < 400) {
					String url2 = "https://api.weather.gov" + response.headers().map().get("location").get(0);
					HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(url2)).timeout(Duration.ofSeconds(5)).build();
					response = client.send(request2, BodyHandlers.ofString());
					responseBody = response.body();
					
				}
				else {
					return null;
				}
			}
			else {
				responseBody = response.body();
			}
		} catch (IOException e) {
			System.out.println(url + "is unavailable");
			return null;
		} catch (InterruptedException e) {
			return null;
		} catch (UnresolvedAddressException e) {
			System.out.println(url + " is unavailable");
			return null;
		}
		
		return responseBody;
	}

}
