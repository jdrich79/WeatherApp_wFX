package application;

import java.util.ArrayList;
import java.util.Collections;
/**
 * This class is responsible for knowing forecasts, knowing activities, and ranking days/times by chosen activities
 * It collaborates with the Activity, WeatherUndergroundAPI, and NWSAPI class
 * @author Cayde.Roothoff
 *
 */
public class RankForecast{
	private ArrayList<DailyForecast> weatherList = new ArrayList<DailyForecast>();
	private Activity activity = new Activity();

	public ArrayList<DailyForecast> getRankedList() {
		return weatherList;
	}

	public RankForecast(ArrayList<DailyForecast> weatherList, Activity activity) {
		this.weatherList = weatherList;
		this.activity = activity;
	}
	
	/**
 	* This method takes in the class array list and returns a new ranked list according to the activity parameters.
 	* @param null
 	*
 	*/
	public ArrayList<DailyForecast> rankItems(){
		
		ArrayList<DailyForecast> rankedList = new ArrayList<DailyForecast>();
		for(DailyForecast day: this.weatherList) {
			calculateAverage(day);
			rankedList.add(day);
		}
		rankedList.sort(null);
		return rankedList;
	}
	
	/**
	 * This method calculates the average difference between weather variables from the chosen activity parameters
	 * @param day
	 */
	private void calculateAverage(DailyForecast day) {
		Integer diffTemperatureMax;
		Integer diffTemperatureMin;

		// day part
		int diffPrecipChance;
		int diffCloudCover;
		Double diffQpf;
		Double diffQpfSnow;
		int diffTemperatureHeatIndex;
		int diffTemperatureWindChill;
		String diffWindPhrase;
		
		Double dayAverage = 0.0;
		Double lowAverage = 0.0;
		
		
		diffTemperatureMax = Math.abs(day.getTemperatureMax() - activity.getBestTemperatureMax());
		diffTemperatureMin = Math.abs(day.getTemperatureMin() - activity.getBestTemperatureMin());

		// day part
		diffPrecipChance = Math.abs(day.getPrecipChanceD() - activity.getBestPrecipChance());
		diffCloudCover = Math.abs(day.getCloudCoverD() - activity.getBestCloudCover());
		diffQpf = Math.abs(day.getQpfD() - activity.getBestQpf()) * 10;
		diffQpfSnow = Math.abs(day.getQpfSnowD() - activity.getBestQpfSnow()) * 10;
		diffTemperatureHeatIndex = Math.abs(day.getTemperatureHeatIndexD() - activity.getBestTemperatureHeatIndex());
		diffTemperatureWindChill = Math.abs(day.getTemperatureWindChillD() - activity.getBestTemperatureWindChill());
		//diffWindPhrase = Math.abs(day.getWindPhraseD() - activity.getBestWindPhrase());
		
		dayAverage = (diffTemperatureMax + diffTemperatureMin + diffPrecipChance + diffCloudCover + diffQpf + diffQpfSnow + diffTemperatureHeatIndex + diffTemperatureWindChill) / 8;
		day.setAverage(dayAverage);
		
	}
}

