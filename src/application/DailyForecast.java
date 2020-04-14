package application;

public class DailyForecast implements Comparable{
	private String weatherService;
    private String date;
	private String dayOfWeek;
	private String narrative;
	private Integer temperatureMax;
	private Integer temperatureMin;

	// daypart
	private String daypartNameD;
	private String daypartNameN;
	private String narrativeD;
	private String narrativeN;
	private Integer precipChanceD;
	private Integer precipChanceN;
	private Integer cloudCoverD;
	private Integer cloudCoverN;
	private Double qpfD;
	private Double qpfN;
	private Double qpfSnowD;
	private Double qpfSnowN;
	private Integer temperatureHeatIndexD;
	private Integer temperatureHeatIndexN;
	private Integer temperatureWindChillD;
	private Integer temperatureWindChillN;
	private String windPhraseD;
	private String windPhraseN;
	private Double average;





	public DailyForecast() {

	}

	public DailyForecast(String weatherService, String date, String dayOfWeek, String narrative, Integer temperatureMax, 
			Integer temperatureMin, String daypartNameD, String daypartNameN, String narrativeD, 
			String narrativeN, Integer precipChanceD, Integer precipChanceN, Integer cloudCoverD, 
			Integer cloudCoverN, String precipTypeD, String precipTypeN, Double qpfD, Double qpfN,
			Double qpfSnowD, Double qpfSnowN, Integer temperatureHeatIndexD, Integer temperatureHeatIndexN,
			Integer temperatureWindChillD, Integer temperatureWindChillN, String windPhraseD, String windPhraseN) {


		this.weatherService = weatherService;
	    this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.narrative = narrative;
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;

		this.daypartNameD = daypartNameD;
		this.daypartNameN = daypartNameN;
		this.narrativeD = narrativeD;
		this.narrativeN = narrativeN;
		this.precipChanceD = precipChanceD;
		this.precipChanceN = precipChanceN;
		this.cloudCoverD = cloudCoverD;
		this.cloudCoverN = cloudCoverN;
		this.qpfD = qpfD;
		this.qpfN = qpfN;
		this.qpfSnowD = qpfSnowD;
		this.qpfSnowN = qpfSnowN;
		this.temperatureHeatIndexD = temperatureHeatIndexD;
		this.temperatureHeatIndexN = temperatureHeatIndexN;
		this.temperatureWindChillD = temperatureWindChillD;
		this.temperatureWindChillN = temperatureWindChillN;
		this.windPhraseD = windPhraseD;
		this.windPhraseN = windPhraseN;
		this.average = 0.0;
	}





    /**
	 * Takes in the DailyForecast object and prints out a narrative of the collected 
	 * data points, in a human readable display.
	 * @param dayF (DailyForecast) - Take in an instance
	 */
	public void weatherNarrative (DailyForecast dayF) {  

		System.out.println("The forecast for " + dayF.getDayOfWeek() + ", " + dayF.getDate() + " is:");
		System.out.println(dayF.getNarrative());

		if (dayF.getTemperatureMax() == 989) { 
			// 989 value assigned to catch Null values and to display different message.
			System.out.println("Low for today is: " + dayF.getTemperatureMin() + " F");
		} else {
			System.out.println("Today's High is " + dayF.getTemperatureMax() +
					" F and Low is " + dayF.getTemperatureMin() + "F");
			System.out.println("\nThe Day and Evening forecasts:\n");
		}

		// PART DAY FORECASTS

		if (!dayF.getDaypartNameD().equals("XX")) {
			// "XX" value assigned to catch Null values and to display a different message
			System.out.println(dayF.getDaypartNameD() + ":");
			System.out.println(dayF.getNarrativeD());
			System.out.println("Rain: " + dayF.getPrecipChanceD() +"% / Inches: " + dayF.getQpfD());

			String snowRange = ""; // To a blank snowRange something to display
			System.out.println("Snow: " + dayF.getQpfSnowD() + " inches. With a range of " 
					+ snowRange);

			System.out.println("Cloud cover: " + dayF.getCloudCoverD() + "%");
			System.out.println("Heat Index: " + dayF.getTemperatureHeatIndexD() + 
					"F / Wind Chill: " + dayF.getTemperatureWindChillD() + "F");
			System.out.println("Wind: " + dayF.getWindPhraseD());
		}
		System.out.println();
		System.out.println(dayF.getDaypartNameN() + ":");
		System.out.println(dayF.getNarrativeN());
		System.out.println("Rain: " + dayF.getPrecipChanceN() +"% / Inches: " + dayF.getQpfN());
		System.out.println("Snow: " + dayF.getQpfSnowN() + " inches."); 
		System.out.println("Cloud cover: " + dayF.getCloudCoverN() + "%");
		System.out.println("Heat Index: " + dayF.getTemperatureHeatIndexN() +
				"F / Wind Chill: " + dayF.getTemperatureWindChillN() + "F");
		System.out.println("Wind: " + dayF.getWindPhraseN());          
		System.out.println("\n\n");


	}
	
	public String getWeatherService() {
	    return weatherService;
	}

	public String getDate() {
		return date;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getNarrative() {
		return narrative;
	}

	public Integer getTemperatureMax() {
		return temperatureMax;
	}

	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	public String getDaypartNameD() {
		return daypartNameD;
	}

	public String getDaypartNameN() {
		return daypartNameN;
	}

	public String getNarrativeD() {
		return narrativeD;
	}

	public String getNarrativeN() {
		return narrativeN;
	}

	public Integer getPrecipChanceD() {
		return precipChanceD;
	}

	public Integer getPrecipChanceN() {
		return precipChanceN;
	}

	public Integer getCloudCoverD() {
		return cloudCoverD;
	}

	public Integer getCloudCoverN() {
		return cloudCoverN;
	}

	public Double getQpfD() {
		return qpfD;
	}

	public Double getQpfN() {
		return qpfN;
	}

	public Double getQpfSnowD() {
		return qpfSnowD;
	}

	public Double getQpfSnowN() {
		return qpfSnowN;
	}

	public Integer getTemperatureHeatIndexD() {
		return temperatureHeatIndexD;
	}

	public Integer getTemperatureHeatIndexN() {
		return temperatureHeatIndexN;
	}

	public Integer getTemperatureWindChillD() {
		return temperatureWindChillD;
	}

	public Integer getTemperatureWindChillN() {
		return temperatureWindChillN;
	}

	public String getWindPhraseD() {
		return windPhraseD;
	}

	public String getWindPhraseN() {
		return windPhraseN;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
	
	@Override
	public int compareTo(Object otherDay) {
		DailyForecast myOtherDay = (DailyForecast) otherDay;
		if (myOtherDay.getAverage() == average) return 0;
		if (average - myOtherDay.getAverage() < 0) return -1;
		return 1;
	}
	
}

