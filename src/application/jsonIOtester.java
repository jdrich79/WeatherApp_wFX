package application;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class jsonIOtester {

	@Test
	void fileReadWriteTest() {
		JSONInputOutput jio = new JSONInputOutput();
		ArrayList<Location> writeLocations = new ArrayList<Location>();
		ArrayList<Location> readLocations = new ArrayList<Location>();
		String testFile = "testfile.json";
		
		for (int i = 0; i < 10; i++) {
			writeLocations.add(new Location());
			writeLocations.get(i).setDisplayName("Display Name " + i);
			writeLocations.get(i).setLatitude(Integer.toString(i));
			writeLocations.get(i).setLongitude(Integer.toString(i));
			
		}
		
		jio.fileWriter(writeLocations, testFile);
		readLocations = jio.fileReader(testFile);
		
		for (int j = 0; j < 10; j++) {
			
			assertEquals(writeLocations.get(j).getDisplayName(), readLocations.get(j).getDisplayName());
			assertEquals(writeLocations.get(j).getLatitude(), readLocations.get(j).getLatitude());
			assertEquals(writeLocations.get(j).getLongitude(), readLocations.get(j).getLongitude());
		}
		
	}
	
	@Test
	void parseGPSTest() {
		
		String responseBody = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"s\": \"https://schema.org/\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"@id\": \"s:GeoCoordinates\",\r\n" + 
				"                \"@type\": \"geo:wktLiteral\"\r\n" + 
				"            },\r\n" + 
				"            \"city\": \"s:addressLocality\",\r\n" + 
				"            \"state\": \"s:addressRegion\",\r\n" + 
				"            \"distance\": {\r\n" + 
				"                \"@id\": \"s:Distance\",\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"bearing\": {\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"value\": {\r\n" + 
				"                \"@id\": \"s:value\"\r\n" + 
				"            },\r\n" + 
				"            \"unitCode\": {\r\n" + 
				"                \"@id\": \"s:unitCode\",\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastOffice\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastGridData\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"publicZone\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"county\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"id\": \"https://api.weather.gov/points/39.7456,-97.0892\",\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"Point\",\r\n" + 
				"        \"coordinates\": [\r\n" + 
				"            -97.089200000000005,\r\n" + 
				"            39.745600000000003\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"@id\": \"https://api.weather.gov/points/39.7456,-97.0892\",\r\n" + 
				"        \"@type\": \"wx:Point\",\r\n" + 
				"        \"cwa\": \"TOP\",\r\n" + 
				"        \"forecastOffice\": \"https://api.weather.gov/offices/TOP\",\r\n" + 
				"        \"gridX\": 31,\r\n" + 
				"        \"gridY\": 80,\r\n" + 
				"        \"forecast\": \"https://api.weather.gov/gridpoints/TOP/31,80/forecast\",\r\n" + 
				"        \"forecastHourly\": \"https://api.weather.gov/gridpoints/TOP/31,80/forecast/hourly\",\r\n" + 
				"        \"forecastGridData\": \"https://api.weather.gov/gridpoints/TOP/31,80\",\r\n" + 
				"        \"observationStations\": \"https://api.weather.gov/gridpoints/TOP/31,80/stations\",\r\n" + 
				"        \"relativeLocation\": {\r\n" + 
				"            \"type\": \"Feature\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"type\": \"Point\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    -97.086661000000007,\r\n" + 
				"                    39.679375999999998\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"properties\": {\r\n" + 
				"                \"city\": \"Linn\",\r\n" + 
				"                \"state\": \"KS\",\r\n" + 
				"                \"distance\": {\r\n" + 
				"                    \"value\": 7366.9851976443715,\r\n" + 
				"                    \"unitCode\": \"unit:m\"\r\n" + 
				"                },\r\n" + 
				"                \"bearing\": {\r\n" + 
				"                    \"value\": 358,\r\n" + 
				"                    \"unitCode\": \"unit:degrees_true\"\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"forecastZone\": \"https://api.weather.gov/zones/forecast/KSZ009\",\r\n" + 
				"        \"county\": \"https://api.weather.gov/zones/county/KSC201\",\r\n" + 
				"        \"fireWeatherZone\": \"https://api.weather.gov/zones/fire/KSZ009\",\r\n" + 
				"        \"timeZone\": \"America/Chicago\",\r\n" + 
				"        \"radarStation\": \"KTWX\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		String responseBody2 = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"s\": \"https://schema.org/\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"@id\": \"s:GeoCoordinates\",\r\n" + 
				"                \"@type\": \"geo:wktLiteral\"\r\n" + 
				"            },\r\n" + 
				"            \"city\": \"s:addressLocality\",\r\n" + 
				"            \"state\": \"s:addressRegion\",\r\n" + 
				"            \"distance\": {\r\n" + 
				"                \"@id\": \"s:Distance\",\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"bearing\": {\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"value\": {\r\n" + 
				"                \"@id\": \"s:value\"\r\n" + 
				"            },\r\n" + 
				"            \"unitCode\": {\r\n" + 
				"                \"@id\": \"s:unitCode\",\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastOffice\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastGridData\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"publicZone\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"county\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"id\": \"https://api.weather.gov/points/39.7391999,-104\",\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"Point\",\r\n" + 
				"        \"coordinates\": [\r\n" + 
				"            -104,\r\n" + 
				"            39.739199900000003\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"@id\": \"https://api.weather.gov/points/39.7391999,-104\",\r\n" + 
				"        \"@type\": \"wx:Point\",\r\n" + 
				"        \"cwa\": \"BOU\",\r\n" + 
				"        \"forecastOffice\": \"https://api.weather.gov/offices/BOU\",\r\n" + 
				"        \"gridX\": 96,\r\n" + 
				"        \"gridY\": 58,\r\n" + 
				"        \"forecast\": \"https://api.weather.gov/gridpoints/BOU/96,58/forecast\",\r\n" + 
				"        \"forecastHourly\": \"https://api.weather.gov/gridpoints/BOU/96,58/forecast/hourly\",\r\n" + 
				"        \"forecastGridData\": \"https://api.weather.gov/gridpoints/BOU/96,58\",\r\n" + 
				"        \"observationStations\": \"https://api.weather.gov/gridpoints/BOU/96,58/stations\",\r\n" + 
				"        \"relativeLocation\": {\r\n" + 
				"            \"type\": \"Feature\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"type\": \"Point\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    -104.043065,\r\n" + 
				"                    39.615811999999998\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"properties\": {\r\n" + 
				"                \"city\": \"Deer Trail\",\r\n" + 
				"                \"state\": \"CO\",\r\n" + 
				"                \"distance\": {\r\n" + 
				"                    \"value\": 14206.521167808369,\r\n" + 
				"                    \"unitCode\": \"unit:m\"\r\n" + 
				"                },\r\n" + 
				"                \"bearing\": {\r\n" + 
				"                    \"value\": 15,\r\n" + 
				"                    \"unitCode\": \"unit:degrees_true\"\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"forecastZone\": \"https://api.weather.gov/zones/forecast/COZ045\",\r\n" + 
				"        \"county\": \"https://api.weather.gov/zones/county/COC005\",\r\n" + 
				"        \"fireWeatherZone\": \"https://api.weather.gov/zones/fire/COZ245\",\r\n" + 
				"        \"timeZone\": \"America/Denver\",\r\n" + 
				"        \"radarStation\": \"KFTG\"\r\n" + 
				"    }\r\n" + 
				"}";
		JSONInputOutput jio = new JSONInputOutput();
		ArrayList<String> urls = jio.parseGPS(responseBody);
		ArrayList<String> urls2 = jio.parseGPS(responseBody2);
		
		assertEquals("https://api.weather.gov/gridpoints/TOP/31,80/forecast", urls.get(0));
		assertEquals("https://api.weather.gov/gridpoints/TOP/31,80", urls.get(1));
		assertEquals("https://api.weather.gov/gridpoints/BOU/96,58/forecast", urls2.get(0));
		assertEquals("https://api.weather.gov/gridpoints/BOU/96,58", urls2.get(1));
	}
	
	@Test
	void parseWeatherTest() {
		
		String forecastResponseBody = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"GeometryCollection\",\r\n" + 
				"        \"geometries\": [\r\n" + 
				"            {\r\n" + 
				"                \"type\": \"Point\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    -104.01246159999999,\r\n" + 
				"                    39.736632800000002\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"type\": \"Polygon\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    [\r\n" + 
				"                        [\r\n" + 
				"                            -104.0277404,\r\n" + 
				"                            39.746899200000001\r\n" + 
				"                        ],\r\n" + 
				"                        [\r\n" + 
				"                            -104.0258327,\r\n" + 
				"                            39.724897900000002\r\n" + 
				"                        ],\r\n" + 
				"                        [\r\n" + 
				"                            -103.99718559999999,\r\n" + 
				"                            39.726364500000003\r\n" + 
				"                        ],\r\n" + 
				"                        [\r\n" + 
				"                            -103.9990873,\r\n" + 
				"                            39.748366000000004\r\n" + 
				"                        ],\r\n" + 
				"                        [\r\n" + 
				"                            -104.0277404,\r\n" + 
				"                            39.746899200000001\r\n" + 
				"                        ]\r\n" + 
				"                    ]\r\n" + 
				"                ]\r\n" + 
				"            }\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"updated\": \"2020-04-02T01:04:00+00:00\",\r\n" + 
				"        \"units\": \"us\",\r\n" + 
				"        \"forecastGenerator\": \"BaselineForecastGenerator\",\r\n" + 
				"        \"generatedAt\": \"2020-04-02T01:15:06+00:00\",\r\n" + 
				"        \"updateTime\": \"2020-04-02T01:04:00+00:00\",\r\n" + 
				"        \"validTimes\": \"2020-04-01T19:00:00+00:00/P7DT11H\",\r\n" + 
				"        \"elevation\": {\r\n" + 
				"            \"value\": 1527.9624000000001,\r\n" + 
				"            \"unitCode\": \"unit:m\"\r\n" + 
				"        },\r\n" + 
				"        \"periods\": [\r\n" + 
				"            {\r\n" + 
				"                \"number\": 1,\r\n" + 
				"                \"name\": \"Tonight\",\r\n" + 
				"                \"startTime\": \"2020-04-01T19:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-02T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 30,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": \"rising\",\r\n" + 
				"                \"windSpeed\": \"5 to 23 mph\",\r\n" + 
				"                \"windDirection\": \"NE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/wind_bkn?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Cloudy\",\r\n" + 
				"                \"detailedForecast\": \"Mostly cloudy. Low around 30, with temperatures rising to around 34 overnight. Northeast wind 5 to 23 mph, with gusts as high as 32 mph.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 2,\r\n" + 
				"                \"name\": \"Thursday\",\r\n" + 
				"                \"startTime\": \"2020-04-02T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-02T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 38,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": \"falling\",\r\n" + 
				"                \"windSpeed\": \"12 to 18 mph\",\r\n" + 
				"                \"windDirection\": \"NE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/bkn/snow,60?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Cloudy then Snow Showers Likely\",\r\n" + 
				"                \"detailedForecast\": \"Snow showers likely and a slight chance of drizzle after 1pm. Mostly cloudy. High near 38, with temperatures falling to around 30 in the afternoon. Northeast wind 12 to 18 mph, with gusts as high as 28 mph. Chance of precipitation is 60%. New snow accumulation of less than half an inch possible.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 3,\r\n" + 
				"                \"name\": \"Thursday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-02T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-03T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 16,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"8 to 18 mph\",\r\n" + 
				"                \"windDirection\": \"N\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/snow,70/snow,40?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Light Snow Likely\",\r\n" + 
				"                \"detailedForecast\": \"Snow likely. Cloudy, with a low around 16. North wind 8 to 18 mph, with gusts as high as 30 mph. Chance of precipitation is 70%. New snow accumulation of less than one inch possible.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 4,\r\n" + 
				"                \"name\": \"Friday\",\r\n" + 
				"                \"startTime\": \"2020-04-03T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-03T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 41,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"1 to 12 mph\",\r\n" + 
				"                \"windDirection\": \"ENE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/bkn?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Partly Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Partly sunny, with a high near 41. East northeast wind 1 to 12 mph, with gusts as high as 16 mph.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 5,\r\n" + 
				"                \"name\": \"Friday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-03T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-04T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 26,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"12 to 15 mph\",\r\n" + 
				"                \"windDirection\": \"SE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/sct?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Partly Cloudy\",\r\n" + 
				"                \"detailedForecast\": \"Partly cloudy, with a low around 26. Southeast wind 12 to 15 mph, with gusts as high as 22 mph.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 6,\r\n" + 
				"                \"name\": \"Saturday\",\r\n" + 
				"                \"startTime\": \"2020-04-04T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-04T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 59,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"12 to 15 mph\",\r\n" + 
				"                \"windDirection\": \"SSE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/sct?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Mostly sunny, with a high near 59.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 7,\r\n" + 
				"                \"name\": \"Saturday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-04T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-05T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 33,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"12 mph\",\r\n" + 
				"                \"windDirection\": \"SSE\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/bkn?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Cloudy\",\r\n" + 
				"                \"detailedForecast\": \"Mostly cloudy, with a low around 33.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 8,\r\n" + 
				"                \"name\": \"Sunday\",\r\n" + 
				"                \"startTime\": \"2020-04-05T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-05T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 69,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"10 mph\",\r\n" + 
				"                \"windDirection\": \"SSW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/sct?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Mostly sunny, with a high near 69.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 9,\r\n" + 
				"                \"name\": \"Sunday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-05T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-06T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 36,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"10 mph\",\r\n" + 
				"                \"windDirection\": \"SSW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/sct?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Partly Cloudy\",\r\n" + 
				"                \"detailedForecast\": \"Partly cloudy, with a low around 36.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 10,\r\n" + 
				"                \"name\": \"Monday\",\r\n" + 
				"                \"startTime\": \"2020-04-06T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-06T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 71,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"10 mph\",\r\n" + 
				"                \"windDirection\": \"SW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/few?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Sunny, with a high near 71.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 11,\r\n" + 
				"                \"name\": \"Monday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-06T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-07T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 39,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"10 mph\",\r\n" + 
				"                \"windDirection\": \"SW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/few?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Clear\",\r\n" + 
				"                \"detailedForecast\": \"Mostly clear, with a low around 39.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 12,\r\n" + 
				"                \"name\": \"Tuesday\",\r\n" + 
				"                \"startTime\": \"2020-04-07T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-07T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 69,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"12 mph\",\r\n" + 
				"                \"windDirection\": \"WSW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/few?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Sunny, with a high near 69.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 13,\r\n" + 
				"                \"name\": \"Tuesday Night\",\r\n" + 
				"                \"startTime\": \"2020-04-07T18:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-08T06:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": false,\r\n" + 
				"                \"temperature\": 35,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"7 to 10 mph\",\r\n" + 
				"                \"windDirection\": \"NW\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/night/bkn?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Mostly Cloudy\",\r\n" + 
				"                \"detailedForecast\": \"Mostly cloudy, with a low around 35.\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"number\": 14,\r\n" + 
				"                \"name\": \"Wednesday\",\r\n" + 
				"                \"startTime\": \"2020-04-08T06:00:00-06:00\",\r\n" + 
				"                \"endTime\": \"2020-04-08T18:00:00-06:00\",\r\n" + 
				"                \"isDaytime\": true,\r\n" + 
				"                \"temperature\": 62,\r\n" + 
				"                \"temperatureUnit\": \"F\",\r\n" + 
				"                \"temperatureTrend\": null,\r\n" + 
				"                \"windSpeed\": \"6 to 9 mph\",\r\n" + 
				"                \"windDirection\": \"N\",\r\n" + 
				"                \"icon\": \"https://api.weather.gov/icons/land/day/bkn?size=medium\",\r\n" + 
				"                \"shortForecast\": \"Partly Sunny\",\r\n" + 
				"                \"detailedForecast\": \"Partly sunny, with a high near 62.\"\r\n" + 
				"            }\r\n" + 
				"        ]\r\n" + 
				"    }\r\n" + 
				"}";
		String forecastGridDataResponseBody = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"s\": \"https://schema.org/\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"@id\": \"s:GeoCoordinates\",\r\n" + 
				"                \"@type\": \"geo:wktLiteral\"\r\n" + 
				"            },\r\n" + 
				"            \"city\": \"s:addressLocality\",\r\n" + 
				"            \"state\": \"s:addressRegion\",\r\n" + 
				"            \"distance\": {\r\n" + 
				"                \"@id\": \"s:Distance\",\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"bearing\": {\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"value\": {\r\n" + 
				"                \"@id\": \"s:value\"\r\n" + 
				"            },\r\n" + 
				"            \"uom\": {\r\n" + 
				"                \"@id\": \"s:unitCode\",\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastOffice\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastGridData\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"publicZone\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"county\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"id\": \"https://api.weather.gov/gridpoints/BOU/96,58\",\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"Polygon\",\r\n" + 
				"        \"coordinates\": [\r\n" + 
				"            [\r\n" + 
				"                [\r\n" + 
				"                    -104.0277404,\r\n" + 
				"                    39.746899200000001\r\n" + 
				"                ],\r\n" + 
				"                [\r\n" + 
				"                    -104.0258327,\r\n" + 
				"                    39.724897900000002\r\n" + 
				"                ],\r\n" + 
				"                [\r\n" + 
				"                    -103.99718569999999,\r\n" + 
				"                    39.726364500000003\r\n" + 
				"                ],\r\n" + 
				"                [\r\n" + 
				"                    -103.99908739999999,\r\n" + 
				"                    39.748366000000004\r\n" + 
				"                ],\r\n" + 
				"                [\r\n" + 
				"                    -104.0277404,\r\n" + 
				"                    39.746899200000001\r\n" + 
				"                ]\r\n" + 
				"            ]\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"@id\": \"https://api.weather.gov/gridpoints/BOU/96,58\",\r\n" + 
				"        \"@type\": \"wx:Gridpoint\",\r\n" + 
				"        \"updateTime\": \"2020-04-01T21:15:52+00:00\",\r\n" + 
				"        \"validTimes\": \"2020-04-01T15:00:00+00:00/P7DT15H\",\r\n" + 
				"        \"elevation\": {\r\n" + 
				"            \"value\": 1527.9624000000001,\r\n" + 
				"            \"unitCode\": \"unit:m\"\r\n" + 
				"        },\r\n" + 
				"        \"forecastOffice\": \"https://api.weather.gov/offices/BOU\",\r\n" + 
				"        \"gridId\": \"BOU\",\r\n" + 
				"        \"gridX\": \"96\",\r\n" + 
				"        \"gridY\": \"58\",\r\n" + 
				"        \"temperature\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -6.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 15.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.111111111111143\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.111111111111143\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T20:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6666666666666856\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"dewpoint\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -9.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T23:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -6.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T01:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T03:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T23:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T01:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T05:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T01:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T03:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T10:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T04:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T22:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"maxTemperature\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 22.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 15.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"minTemperature\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T02:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"relativeHumidity\": {\r\n" + 
				"            \"sourceUnit\": \"%\",\r\n" + 
				"            \"uom\": \"unit:percent\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 48\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 30\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 32\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 36\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 43\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 54\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 76\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 82\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 92\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 100\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 88\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 78\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 70\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 67\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 69\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 75\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 81\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 96\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 100\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 96\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 100\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 96\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 92\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 88\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 77\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 68\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 53\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 47\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 39\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 37\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 39\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 41\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 49\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 56\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 58\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 66\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 69\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 75\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 78\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 81\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 78\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 75\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 69\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 59\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 34\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 32\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 35\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 43\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 48\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 54\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 73\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 79\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 89\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 96\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 92\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 79\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 73\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 52\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 28\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 24\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 22\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 27\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 46\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 53\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 70\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 73\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 75\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 72\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 70\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 64\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 55\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 48\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 31\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 16\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 23\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 27\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 31\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 35\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 45\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T09:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 57\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 55\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 47\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 35\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 29\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 24\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 23\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 27\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 34\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 60\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 70\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 79\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 82\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 79\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 73\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 54\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 46\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 39\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 35\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 31\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 30\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 28\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 31\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"apparentTemperature\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -12.222222222222229\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -13.333333333333314\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -12.777777777777771\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -13.333333333333314\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -13.888888888888857\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -15\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -14.444444444444457\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -11.111111111111086\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -9.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 15.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.111111111111143\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.333333333333371\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20.000000000000057\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 18.888888888888971\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 17.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.777777777777828\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.111111111111143\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12.222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T20:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 16.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15.5555555555556\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14.444444444444514\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"heatIndex\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/P4DT21H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 21.666666666666742\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21.1111111111112\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/P2DT1H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"windChill\": {\r\n" + 
				"            \"sourceUnit\": \"F\",\r\n" + 
				"            \"uom\": \"unit:degC\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -10.555555555555543\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -12.222222222222229\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -13.333333333333314\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -12.777777777777771\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -13.333333333333314\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -13.888888888888857\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -15\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -14.444444444444457\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -11.111111111111086\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -7.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -9.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -8.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -6.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT10H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -3.3333333333333144\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -3.8888888888888573\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T16:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.3333333333333712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.1111111111111427\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.8888888888889142\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T16:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.7777777777777715\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.5555555555555429\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT15H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.4444444444444571\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.2222222222222285\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.55555555555554292\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": -1.1111111111110858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": -1.6666666666666288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.6666666666666856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T16:00:00+00:00/PT9H\",\r\n" + 
				"                    \"value\": null\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"skyCover\": {\r\n" + 
				"            \"sourceUnit\": \"%\",\r\n" + 
				"            \"uom\": \"unit:percent\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 36\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 53\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 57\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 58\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 60\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 65\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 66\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 64\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 61\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 59\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 56\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 54\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 57\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 64\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 70\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 77\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 83\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 82\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 84\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 84\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 81\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 79\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 80\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 82\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 84\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 86\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 88\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 89\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 90\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 91\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 88\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 85\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 74\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 72\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 69\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 68\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 46\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 45\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 37\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 50\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 69\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 62\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 49\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 41\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 38\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 37\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 55\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 51\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 42\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 37\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 33\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 21\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 29\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 45\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 53\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 57\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 64\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 67\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 44\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 32\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 29\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 52\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 24\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 11\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 9\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 29\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 12\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 13\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 34\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 63\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 52\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 58\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 59\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"windDirection\": {\r\n" + 
				"            \"sourceUnit\": \"degrees\",\r\n" + 
				"            \"uom\": \"unit:degree_(angle)\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 210\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 200\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 190\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 180\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 190\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 200\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 150\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 130\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 110\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 80\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 59.999999999999993\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 340\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 350\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 29.999999999999996\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 50\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 29.999999999999996\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 350\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 59.999999999999993\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 80\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 90\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 100\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 110\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 119.99999999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 130\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 140\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 150\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 170\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 180\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 170\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 150\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 170\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 200\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 210\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 190\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 210\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT18H\",\r\n" + 
				"                    \"value\": 220\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 230\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 239.99999999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 250.00000000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 320\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 330\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 350\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"windSpeed\": {\r\n" + 
				"            \"sourceUnit\": \"kts\",\r\n" + 
				"            \"uom\": \"unit:m_s-1\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 1.5433319999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0.51444400000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.028888\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.5433319999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.5722200000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT9H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT18H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 2.5722200000000002\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"windGust\": {\r\n" + 
				"            \"sourceUnit\": \"kts\",\r\n" + 
				"            \"uom\": \"unit:m_s-1\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.7744359999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10.803324\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 11.317768000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 12.346655999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 13.375544\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 12.346655999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11.317768000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 9.7744359999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 2.5722200000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 9.7744359999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 8.7455479999999994\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"weather\": {\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/P1DT4H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": null,\r\n" + 
				"                            \"weather\": null,\r\n" + 
				"                            \"intensity\": null,\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"slight_chance\",\r\n" + 
				"                            \"weather\": \"snow_showers\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"slight_chance\",\r\n" + 
				"                            \"weather\": \"drizzle\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"chance\",\r\n" + 
				"                            \"weather\": \"snow_showers\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"likely\",\r\n" + 
				"                            \"weather\": \"snow_showers\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"likely\",\r\n" + 
				"                            \"weather\": \"snow\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": \"chance\",\r\n" + 
				"                            \"weather\": \"snow\",\r\n" + 
				"                            \"intensity\": \"light\",\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/P5DT13H\",\r\n" + 
				"                    \"value\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"coverage\": null,\r\n" + 
				"                            \"weather\": null,\r\n" + 
				"                            \"intensity\": null,\r\n" + 
				"                            \"visibility\": null,\r\n" + 
				"                            \"attributes\": null\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"hazards\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"probabilityOfPrecipitation\": {\r\n" + 
				"            \"sourceUnit\": \"%\",\r\n" + 
				"            \"uom\": \"unit:percent\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 2\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 8\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 11\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 4\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 19\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 25\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 31\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 37\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 56\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 71\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 43\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 8\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 9\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 6\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 7\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 1\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 2\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 2\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 1\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 2\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 6\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 7\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT12H\",\r\n" + 
				"                    \"value\": 5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT7H\",\r\n" + 
				"                    \"value\": 12\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"quantitativePrecipitation\": {\r\n" + 
				"            \"sourceUnit\": \"in\",\r\n" + 
				"            \"uom\": \"unit:mm\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 1.27\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 3.048\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0.254\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"iceAccumulation\": {\r\n" + 
				"            \"sourceUnit\": \"in\",\r\n" + 
				"            \"uom\": \"unit:mm\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"snowfallAmount\": {\r\n" + 
				"            \"sourceUnit\": \"in\",\r\n" + 
				"            \"uom\": \"unit:mm\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 5.0800000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 17.779999999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 2.54\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"snowLevel\": {\r\n" + 
				"            \"sourceUnit\": \"ft\",\r\n" + 
				"            \"uom\": \"unit:m\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2447.8488000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2487.7776000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2511.8568\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2567.9400000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2631.9480000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2687.7264\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2732.8368\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2759.9639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2767.8888000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2799.8928000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2808.1224000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2783.7384000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2743.8096\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2767.8888000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2752.0392000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2703.8808000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2688.0312000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2663.9520000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2592.0192000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2560.0152000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2535.6312000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2431.0848000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2464.0032000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2390.2416000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2255.2152000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2150.364\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2036.6736000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1904.0856000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1715.7192\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1524.3048000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1379.22\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1337.7672\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1295.7048\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1161.288\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1007.9736\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 899.46480000000008\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 814.12080000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 744.01679999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 688.23840000000007\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 623.92560000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 529.43759999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 447.14160000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 376.1232\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 300.22800000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 240.1824\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 375.8184\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 268.83359999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 203.91120000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 223.72320000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 379.476\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 606.85680000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 831.79920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 986.94240000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1109.7768000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1199.9976000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1282.2936\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1326.4896000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1320.0888\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1245.4128000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1132.6368\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1023.8232\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 961.94880000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 918.66720000000009\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 887.88240000000008\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 858.31680000000006\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 837.59040000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 823.87440000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 793.08960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 779.06880000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 808.02480000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 883.92000000000007\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1012.5456\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1192.0728000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1437.7416000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1710.5376000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1951.9392\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2111.9592000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2223.8208\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2303.9832000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2380.1831999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2432.6088\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2464.0032000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2484.4248000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2488.0824000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2479.8528000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2472.2328000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2454.2496000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2424.0744\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2384.1456000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2332.6343999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2272.2840000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2187.8544000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2107.9967999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2064.1056000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2079.3456000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2135.7336\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2215.8960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2305.2024000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2404.5672\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2496.0072\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2566.1112000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2621.8896\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2664.2568000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2704.7952\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2730.3984\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2735.8848000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2718.5111999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2683.1544000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2640.1776\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2610.9168\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2574.0360000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2520.0864000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2429.2560000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2327.4528\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2239.9752000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2186.3304000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2155.8504000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2143.9632000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2129.9423999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2136.9528\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2176.2719999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2265.2736\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2377.1352000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2479.8528000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2541.4223999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2584.0944\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2616.0984000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2659.3800000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-06T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2690.1648\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2695.9560000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2663.6472000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2609.0880000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2552.0904\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2522.5248000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2492.3496\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2447.8488000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2366.1624000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2273.5032000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2191.8168000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2137.2575999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2102.8152\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2087.8800000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2079.3456000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2091.5376000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2127.8088000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2193.6456000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2277.1608000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2360.0664000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2424.6840000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2480.4624000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2528.0111999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2579.5224000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-07T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2617.9272000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2631.9480000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2615.1840000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2574.0360000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2520.0864000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2476.5\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2421.0264000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2344.2168000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2217.7248\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2083.6127999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1983.9432000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1970.2272\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1991.8680000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2008.0224000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1951.9392\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1891.8936000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1872.0816000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1950.4152000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2066.2392\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2168.0424000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2193.6456000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2197.3032000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2207.9712\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2256.1296000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-08T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2320.1376\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-09T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2392.0704000000001\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"ceilingHeight\": {\r\n" + 
				"            \"sourceUnit\": \"ft\",\r\n" + 
				"            \"uom\": \"unit:m\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -30.48\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6827.5200000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6766.5600000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6400.8000000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6492.2400000000007\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6858\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5730.2400000000007\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6522.7200000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6400.8000000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5425.4400000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": -30.48\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 792.48000000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 335.28000000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 152.40000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 60.960000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 121.92\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 152.40000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 182.88\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 213.36000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 274.31999999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 335.28000000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 396.24000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 457.20000000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 487.68000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 457.20000000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 426.72000000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 396.24000000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 365.75999999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 335.28000000000003\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"visibility\": {\r\n" + 
				"            \"sourceUnit\": \"mi\",\r\n" + 
				"            \"uom\": \"unit:m\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT13H\",\r\n" + 
				"                    \"value\": 16093.440000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 16061.253120000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 16029.066240000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15948.599040000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15932.5056\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15916.412160000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15884.225279999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15320.954879999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12214.920959999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12697.72416\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14419.722240000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15192.20736\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15755.47776\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 16061.253120000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 16093.440000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 15642.823680000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 14162.227200000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 12263.201280000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9656.0640000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9430.7558400000016\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8626.0838400000011\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7982.3462399999999\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"transportWindSpeed\": {\r\n" + 
				"            \"sourceUnit\": \"kts\",\r\n" + 
				"            \"uom\": \"unit:m_s-1\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.7166600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 4.6299960000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 4.1155520000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.5722200000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 2.057776\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1.5433319999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2.057776\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.0866639999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3.601108\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.6877719999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 7.202216\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 8.2311040000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.7744359999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 9.2599920000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 6.1733279999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.6588840000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 5.1444400000000003\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"transportWindDirection\": {\r\n" + 
				"            \"sourceUnit\": \"degrees\",\r\n" + 
				"            \"uom\": \"unit:degree_(angle)\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 180\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 190\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 210\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 220\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 230\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 239.99999999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 250.00000000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 280\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 350\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT6H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 29.999999999999996\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 50\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 40\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 29.999999999999996\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT5H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT4H\",\r\n" + 
				"                    \"value\": 0\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 10\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 29.999999999999996\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 20\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 350\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 340\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 300\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 210\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 160\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 140\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 150\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 170\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 180\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 200\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 180\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 200\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 150\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"mixingHeight\": {\r\n" + 
				"            \"sourceUnit\": \"ft\",\r\n" + 
				"            \"uom\": \"unit:m\",\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 136.2456\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 820.21680000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1503.8832\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2187.5496000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2581.3512000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2974.848\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 3368.6496000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2818.4856\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2268.0168000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1717.8528000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1178.3568\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 638.86080000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 99.060000000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 105.15600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 110.94720000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 117.04320000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 218.84640000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 320.34480000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 422.14800000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 410.56560000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 398.98320000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 387.4008\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 399.59280000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 411.48000000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 423.67200000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 462.68640000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 501.39600000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 540.41039999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T19:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 593.44560000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T20:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 646.48080000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 699.51600000000008\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T22:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 725.72880000000009\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 751.94159999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 805.89120000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T01:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 586.13040000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T02:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 585.82560000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 626.97360000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T04:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 576.9864\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T05:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 554.43119999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 531.87599999999998\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T07:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 467.56320000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T08:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 403.25040000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 338.93760000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T10:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 369.72239999999999\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T11:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 400.50720000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 431.29200000000003\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T13:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 462.38160000000005\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T14:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 493.77600000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 524.86559999999997\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T16:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 789.43200000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T17:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1053.6936000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1318.26\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-03T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1422.1968000000002\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1322.2224000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T03:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 149.0472\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T06:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 149.0472\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T09:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 148.7424\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T12:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 148.7424\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T15:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 445.00800000000004\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T18:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1110.9960000000001\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T21:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 2354.2752\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-05T00:00:00+00:00/PT1H\",\r\n" + 
				"                    \"value\": 1107.0336\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"hainesIndex\": {\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/PT2H\",\r\n" + 
				"                    \"value\": 4\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T17:00:00+00:00/PT3H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T20:00:00+00:00/PT9H\",\r\n" + 
				"                    \"value\": 4\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T05:00:00+00:00/PT18H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-02T23:00:00+00:00/P1DT12H\",\r\n" + 
				"                    \"value\": 2\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-04T11:00:00+00:00/PT14H\",\r\n" + 
				"                    \"value\": 3\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"lightningActivityLevel\": {\r\n" + 
				"            \"values\": [\r\n" + 
				"                {\r\n" + 
				"                    \"validTime\": \"2020-04-01T15:00:00+00:00/P4DT10H\",\r\n" + 
				"                    \"value\": 1\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"twentyFootWindSpeed\": {\r\n" + 
				"            \"sourceUnit\": \"kts\",\r\n" + 
				"            \"uom\": \"unit:m_s-1\",\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"twentyFootWindDirection\": {\r\n" + 
				"            \"sourceUnit\": \"degrees\",\r\n" + 
				"            \"uom\": \"unit:degree_(angle)\",\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"waveHeight\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"wavePeriod\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"waveDirection\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"primarySwellHeight\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"primarySwellDirection\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"secondarySwellHeight\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"secondarySwellDirection\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"wavePeriod2\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"windWaveHeight\": {\r\n" + 
				"            \"sourceUnit\": null,\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"dispersionIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"pressure\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"probabilityOfTropicalStormWinds\": {\r\n" + 
				"            \"sourceUnit\": \"%\",\r\n" + 
				"            \"uom\": \"unit:percent\",\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"probabilityOfHurricaneWinds\": {\r\n" + 
				"            \"sourceUnit\": \"%\",\r\n" + 
				"            \"uom\": \"unit:percent\",\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf15mphWinds\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf25mphWinds\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf35mphWinds\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf45mphWinds\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf20mphWindGusts\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf30mphWindGusts\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf40mphWindGusts\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf50mphWindGusts\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"potentialOf60mphWindGusts\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"grasslandFireDangerIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"probabilityOfThunder\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"davisStabilityIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"atmosphericDispersionIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"lowVisibilityOccurrenceRiskIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"stability\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        },\r\n" + 
				"        \"redFlagThreatIndex\": {\r\n" + 
				"            \"values\": []\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
				
		JSONInputOutput jio = new JSONInputOutput();
		ArrayList<DailyForecast> fivedays = jio.parseNWSForecast(forecastResponseBody, forecastGridDataResponseBody);
		
		assertEquals(fivedays.get(0).getDayOfWeek(),"WEDNESDAY");
		assertEquals(fivedays.get(1).getDayOfWeek(),"THURSDAY");
		assertEquals(fivedays.get(2).getDayOfWeek(),"FRIDAY");
		assertEquals(fivedays.get(3).getDayOfWeek(),"SATURDAY");
		assertEquals(fivedays.get(4).getDayOfWeek(),"SUNDAY");
		
		assertEquals(fivedays.get(0).getTemperatureMax(),72);
		assertEquals(fivedays.get(1).getTemperatureMax(),38);
		assertEquals(fivedays.get(2).getTemperatureMax(),41);
		assertEquals(fivedays.get(3).getTemperatureMax(),59);
		assertEquals(fivedays.get(4).getTemperatureMax(),69);
		assertEquals(fivedays.get(5).getTemperatureMax(),71);
	
		assertEquals(fivedays.get(0).getTemperatureMin(),30);
		assertEquals(fivedays.get(1).getTemperatureMin(),16);
		assertEquals(fivedays.get(2).getTemperatureMin(),26);
		assertEquals(fivedays.get(3).getTemperatureMin(),33);
		assertEquals(fivedays.get(4).getTemperatureMin(),36);
		assertEquals(fivedays.get(5).getTemperatureMin(),39);
		
		assertEquals(6, fivedays.get(0).getPrecipChanceN());
		assertEquals(40, fivedays.get(1).getPrecipChanceN());
		assertEquals(8, fivedays.get(2).getPrecipChanceN());
		assertEquals(7, fivedays.get(3).getPrecipChanceN());
		assertEquals(3, fivedays.get(4).getPrecipChanceN());
		assertEquals(1, fivedays.get(5).getPrecipChanceN());
		assertEquals(8, fivedays.get(1).getPrecipChanceD());
		assertEquals(24, fivedays.get(2).getPrecipChanceD());
		assertEquals(6, fivedays.get(3).getPrecipChanceD());
		assertEquals(1, fivedays.get(4).getPrecipChanceD());
		assertEquals(1, fivedays.get(5).getPrecipChanceD());
		assertEquals(989, fivedays.get(0).getPrecipChanceD());
		
		assertEquals(989, fivedays.get(0).getCloudCoverD());
		assertEquals(74, fivedays.get(1).getCloudCoverD());
		assertEquals(71, fivedays.get(2).getCloudCoverD());
		assertEquals(41, fivedays.get(3).getCloudCoverD());
		assertEquals(38, fivedays.get(4).getCloudCoverD());
		

		assertEquals(61, fivedays.get(0).getCloudCoverN());
		assertEquals(85, fivedays.get(1).getCloudCoverN());
		assertEquals(49, fivedays.get(2).getCloudCoverN());
		assertEquals(48, fivedays.get(3).getCloudCoverN());
		assertEquals(41, fivedays.get(4).getCloudCoverN());

		
		assertEquals(0, fivedays.get(0).getQpfN());
		assertEquals(.16999999999999998, fivedays.get(1).getQpfN());
		assertEquals(0, fivedays.get(2).getQpfN());
		assertEquals(0, fivedays.get(3).getQpfN());
		assertEquals(0, fivedays.get(4).getQpfN());
		assertEquals(0, fivedays.get(5).getQpfN());
		
		assertEquals(989, fivedays.get(0).getQpfD());
		assertEquals(0, fivedays.get(1).getQpfD());
		assertEquals(.01, fivedays.get(2).getQpfD());
		assertEquals(0, fivedays.get(3).getQpfD());
		assertEquals(0, fivedays.get(4).getQpfD());
		assertEquals(0, fivedays.get(5).getQpfD());
	}

}
