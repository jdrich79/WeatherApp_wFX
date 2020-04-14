package application;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

class CallWUAPITest {

//    @Test
//    void testJArrayHelper() {
//        fail("Not yet implemented");
//    }

    
    String jsonTestResponse = "{\r\n" + 
            "  \"dayOfWeek\": [\r\n" + 
            "    \"Monday\",\r\n" + 
            "    \"Tuesday\",\r\n" + 
            "    \"Wednesday\",\r\n" + 
            "    \"Thursday\",\r\n" + 
            "    \"Friday\",\r\n" + 
            "    \"Saturday\"\r\n" + 
            "  ],\r\n" + 
            "  \"expirationTimeUtc\": [\r\n" + 
            "    1584409191,\r\n" + 
            "    1584409191,\r\n" + 
            "    1584409191,\r\n" + 
            "    1584409191,\r\n" + 
            "    1584409191,\r\n" + 
            "    1584409191\r\n" + 
            "  ],\r\n" + 
            "  \"moonPhase\": [\r\n" + 
            "    \"Last Quarter\",\r\n" + 
            "    \"Waning Crescent\",\r\n" + 
            "    \"Waning Crescent\",\r\n" + 
            "    \"Waning Crescent\",\r\n" + 
            "    \"Waning Crescent\",\r\n" + 
            "    \"Waning Crescent\"\r\n" + 
            "  ],\r\n" + 
            "  \"moonPhaseCode\": [\r\n" + 
            "    \"LQ\",\r\n" + 
            "    \"WNC\",\r\n" + 
            "    \"WNC\",\r\n" + 
            "    \"WNC\",\r\n" + 
            "    \"WNC\",\r\n" + 
            "    \"WNC\"\r\n" + 
            "  ],\r\n" + 
            "  \"moonPhaseDay\": [\r\n" + 
            "    22,\r\n" + 
            "    23,\r\n" + 
            "    24,\r\n" + 
            "    25,\r\n" + 
            "    26,\r\n" + 
            "    27\r\n" + 
            "  ],\r\n" + 
            "  \"moonriseTimeLocal\": [\r\n" + 
            "    \"2020-03-16T02:24:43-0600\",\r\n" + 
            "    \"2020-03-17T03:23:53-0600\",\r\n" + 
            "    \"2020-03-18T04:14:50-0600\",\r\n" + 
            "    \"2020-03-19T04:59:03-0600\",\r\n" + 
            "    \"2020-03-20T05:36:52-0600\",\r\n" + 
            "    \"2020-03-21T06:08:53-0600\"\r\n" + 
            "  ],\r\n" + 
            "  \"moonriseTimeUtc\": [\r\n" + 
            "    1584347083,\r\n" + 
            "    1584437033,\r\n" + 
            "    1584526490,\r\n" + 
            "    1584615543,\r\n" + 
            "    1584704212,\r\n" + 
            "    1584792533\r\n" + 
            "  ],\r\n" + 
            "  \"moonsetTimeLocal\": [\r\n" + 
            "    \"2020-03-16T12:00:30-0600\",\r\n" + 
            "    \"2020-03-17T12:52:46-0600\",\r\n" + 
            "    \"2020-03-18T13:49:18-0600\",\r\n" + 
            "    \"2020-03-19T14:47:43-0600\",\r\n" + 
            "    \"2020-03-20T15:47:35-0600\",\r\n" + 
            "    \"2020-03-21T16:46:36-0600\"\r\n" + 
            "  ],\r\n" + 
            "  \"moonsetTimeUtc\": [\r\n" + 
            "    1584381630,\r\n" + 
            "    1584471166,\r\n" + 
            "    1584560958,\r\n" + 
            "    1584650863,\r\n" + 
            "    1584740855,\r\n" + 
            "    1584830796\r\n" + 
            "  ],\r\n" + 
            "  \"narrative\": [\r\n" + 
            "    \"Considerable cloudiness. Lows overnight in the upper 30s.\",\r\n" + 
            "    \"Mix of sun and clouds. Highs in the low 60s and lows in the low 40s.\",\r\n" + 
            "    \"Plenty of sun. Highs in the mid 60s and lows in the low 40s.\",\r\n" + 
            "    \"Rain mixed with snow. Highs in the low 40s and lows in the upper teens.\",\r\n" + 
            "    \"Snow showers developing in the afternoon. Highs in the low 30s and lows in the low 20s.\",\r\n" + 
            "    \"Partly cloudy. Highs in the low 40s and lows in the upper 20s.\"\r\n" + 
            "  ],\r\n" + 
            "  \"qpf\": [\r\n" + 
            "    0,\r\n" + 
            "    0,\r\n" + 
            "    0.2,\r\n" + 
            "    0.59,\r\n" + 
            "    0.07,\r\n" + 
            "    0\r\n" + 
            "  ],\r\n" + 
            "  \"qpfSnow\": [\r\n" + 
            "    0,\r\n" + 
            "    0,\r\n" + 
            "    0,\r\n" + 
            "    3.6,\r\n" + 
            "    0.7,\r\n" + 
            "    0\r\n" + 
            "  ],\r\n" + 
            "  \"sunriseTimeLocal\": [\r\n" + 
            "    \"2020-03-16T07:08:46-0600\",\r\n" + 
            "    \"2020-03-17T07:07:09-0600\",\r\n" + 
            "    \"2020-03-18T07:05:31-0600\",\r\n" + 
            "    \"2020-03-19T07:03:54-0600\",\r\n" + 
            "    \"2020-03-20T07:02:16-0600\",\r\n" + 
            "    \"2020-03-21T07:00:39-0600\"\r\n" + 
            "  ],\r\n" + 
            "  \"sunriseTimeUtc\": [\r\n" + 
            "    1584364126,\r\n" + 
            "    1584450429,\r\n" + 
            "    1584536731,\r\n" + 
            "    1584623034,\r\n" + 
            "    1584709336,\r\n" + 
            "    1584795639\r\n" + 
            "  ],\r\n" + 
            "  \"sunsetTimeLocal\": [\r\n" + 
            "    \"2020-03-16T19:08:28-0600\",\r\n" + 
            "    \"2020-03-17T19:09:31-0600\",\r\n" + 
            "    \"2020-03-18T19:10:33-0600\",\r\n" + 
            "    \"2020-03-19T19:11:35-0600\",\r\n" + 
            "    \"2020-03-20T19:12:36-0600\",\r\n" + 
            "    \"2020-03-21T19:13:38-0600\"\r\n" + 
            "  ],\r\n" + 
            "  \"sunsetTimeUtc\": [\r\n" + 
            "    1584407308,\r\n" + 
            "    1584493771,\r\n" + 
            "    1584580233,\r\n" + 
            "    1584666695,\r\n" + 
            "    1584753156,\r\n" + 
            "    1584839618\r\n" + 
            "  ],\r\n" + 
            "  \"temperatureMax\": [\r\n" + 
            "    null,\r\n" + 
            "    60,\r\n" + 
            "    64,\r\n" + 
            "    43,\r\n" + 
            "    30,\r\n" + 
            "    42\r\n" + 
            "  ],\r\n" + 
            "  \"temperatureMin\": [\r\n" + 
            "    37,\r\n" + 
            "    40,\r\n" + 
            "    40,\r\n" + 
            "    19,\r\n" + 
            "    21,\r\n" + 
            "    27\r\n" + 
            "  ],\r\n" + 
            "  \"validTimeLocal\": [\r\n" + 
            "    \"2020-03-16T07:00:00-0600\",\r\n" + 
            "    \"2020-03-17T07:00:00-0600\",\r\n" + 
            "    \"2020-03-18T07:00:00-0600\",\r\n" + 
            "    \"2020-03-19T07:00:00-0600\",\r\n" + 
            "    \"2020-03-20T07:00:00-0600\",\r\n" + 
            "    \"2020-03-21T07:00:00-0600\"\r\n" + 
            "  ],\r\n" + 
            "  \"validTimeUtc\": [\r\n" + 
            "    1584363600,\r\n" + 
            "    1584450000,\r\n" + 
            "    1584536400,\r\n" + 
            "    1584622800,\r\n" + 
            "    1584709200,\r\n" + 
            "    1584795600\r\n" + 
            "  ],\r\n" + 
            "  \"daypart\": [\r\n" + 
            "    {\r\n" + 
            "      \"cloudCover\": [\r\n" + 
            "        null,\r\n" + 
            "        76,\r\n" + 
            "        66,\r\n" + 
            "        21,\r\n" + 
            "        17,\r\n" + 
            "        81,\r\n" + 
            "        100,\r\n" + 
            "        90,\r\n" + 
            "        80,\r\n" + 
            "        65,\r\n" + 
            "        30,\r\n" + 
            "        47\r\n" + 
            "      ],\r\n" + 
            "      \"dayOrNight\": [\r\n" + 
            "        null,\r\n" + 
            "        \"N\",\r\n" + 
            "        \"D\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"D\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"D\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"D\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"D\",\r\n" + 
            "        \"N\"\r\n" + 
            "      ],\r\n" + 
            "      \"daypartName\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Tonight\",\r\n" + 
            "        \"Tomorrow\",\r\n" + 
            "        \"Tomorrow night\",\r\n" + 
            "        \"Wednesday\",\r\n" + 
            "        \"Wednesday night\",\r\n" + 
            "        \"Thursday\",\r\n" + 
            "        \"Thursday night\",\r\n" + 
            "        \"Friday\",\r\n" + 
            "        \"Friday night\",\r\n" + 
            "        \"Saturday\",\r\n" + 
            "        \"Saturday night\"\r\n" + 
            "      ],\r\n" + 
            "      \"iconCode\": [\r\n" + 
            "        null,\r\n" + 
            "        27,\r\n" + 
            "        30,\r\n" + 
            "        29,\r\n" + 
            "        34,\r\n" + 
            "        11,\r\n" + 
            "        5,\r\n" + 
            "        16,\r\n" + 
            "        14,\r\n" + 
            "        16,\r\n" + 
            "        30,\r\n" + 
            "        29\r\n" + 
            "      ],\r\n" + 
            "      \"iconCodeExtend\": [\r\n" + 
            "        null,\r\n" + 
            "        2700,\r\n" + 
            "        3000,\r\n" + 
            "        2900,\r\n" + 
            "        3400,\r\n" + 
            "        1100,\r\n" + 
            "        500,\r\n" + 
            "        6900,\r\n" + 
            "        7803,\r\n" + 
            "        6900,\r\n" + 
            "        3000,\r\n" + 
            "        2900\r\n" + 
            "      ],\r\n" + 
            "      \"narrative\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Partly cloudy skies this evening will become overcast overnight. Sprinkles or flurries possible. Low 37F. N winds at 10 to 20 mph, decreasing to 5 to 10 mph.\",\r\n" + 
            "        \"Partly cloudy skies. High near 60F. Winds N at 5 to 10 mph.\",\r\n" + 
            "        \"Some clouds early will give way to generally clear conditions overnight. Low around 40F. Winds WSW at 5 to 10 mph.\",\r\n" + 
            "        \"Sunshine and some clouds. High 64F. Winds S at 10 to 20 mph.\",\r\n" + 
            "        \"Cloudy with showers. Low around 40F. Winds NNW at 10 to 15 mph. Chance of rain 80%.\",\r\n" + 
            "        \"Rain and snow in the morning, becoming all snow in the afternoon. Morning high of 43F with temps falling to near freezing. Winds N at 15 to 25 mph. Chance of rain 90%. Snow accumulating 1 to 3 inches.  Winds could occasionally gust over 40 mph.\",\r\n" + 
            "        \"Snow in the evening will taper off and give way to cloudy skies overnight. Low 19F. Winds NE at 10 to 20 mph. Chance of snow 70%. Snow accumulations less than one inch.\",\r\n" + 
            "        \"Mostly cloudy. Snow showers around in the afternoon. High near 30F. Winds ENE at 10 to 15 mph. Chance of snow 60%.\",\r\n" + 
            "        \"Snow in the evening will give way to some clearing overnight. Low 21F. Winds NNW at 5 to 10 mph. Chance of snow 60%. Snow accumulations less than one inch.\",\r\n" + 
            "        \"Intervals of clouds and sunshine. High 42F. Winds ENE at 5 to 10 mph.\",\r\n" + 
            "        \"A few clouds from time to time. Low 27F. Winds SW at 5 to 10 mph.\"\r\n" + 
            "      ],\r\n" + 
            "      \"precipChance\": [\r\n" + 
            "        null,\r\n" + 
            "        10,\r\n" + 
            "        10,\r\n" + 
            "        10,\r\n" + 
            "        10,\r\n" + 
            "        80,\r\n" + 
            "        90,\r\n" + 
            "        70,\r\n" + 
            "        60,\r\n" + 
            "        60,\r\n" + 
            "        10,\r\n" + 
            "        20\r\n" + 
            "      ],\r\n" + 
            "      \"precipType\": [\r\n" + 
            "        null,\r\n" + 
            "        \"precip\",\r\n" + 
            "        \"rain\",\r\n" + 
            "        \"precip\",\r\n" + 
            "        \"rain\",\r\n" + 
            "        \"rain\",\r\n" + 
            "        \"rain\",\r\n" + 
            "        \"snow\",\r\n" + 
            "        \"snow\",\r\n" + 
            "        \"snow\",\r\n" + 
            "        \"rain\",\r\n" + 
            "        \"precip\"\r\n" + 
            "      ],\r\n" + 
            "      \"qpf\": [\r\n" + 
            "        null,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0.2,\r\n" + 
            "        0.52,\r\n" + 
            "        0.07,\r\n" + 
            "        0.03,\r\n" + 
            "        0.03,\r\n" + 
            "        0,\r\n" + 
            "        0\r\n" + 
            "      ],\r\n" + 
            "      \"qpfSnow\": [\r\n" + 
            "        null,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        2.9,\r\n" + 
            "        0.7,\r\n" + 
            "        0.3,\r\n" + 
            "        0.4,\r\n" + 
            "        0,\r\n" + 
            "        0\r\n" + 
            "      ],\r\n" + 
            "      \"qualifierCode\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Q7625\",\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        \"Q1021\",\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null\r\n" + 
            "      ],\r\n" + 
            "      \"qualifierPhrase\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Sprinkles or flurries possible.\",\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        \"Winds could occasionally gust over 40 mph.\",\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null,\r\n" + 
            "        null\r\n" + 
            "      ],\r\n" + 
            "      \"relativeHumidity\": [\r\n" + 
            "        null,\r\n" + 
            "        77,\r\n" + 
            "        54,\r\n" + 
            "        54,\r\n" + 
            "        34,\r\n" + 
            "        64,\r\n" + 
            "        77,\r\n" + 
            "        79,\r\n" + 
            "        70,\r\n" + 
            "        76,\r\n" + 
            "        62,\r\n" + 
            "        70\r\n" + 
            "      ],\r\n" + 
            "      \"snowRange\": [\r\n" + 
            "        null,\r\n" + 
            "        \"\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"1-3\",\r\n" + 
            "        \"< 1\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"< 1\",\r\n" + 
            "        \"\",\r\n" + 
            "        \"\"\r\n" + 
            "      ],\r\n" + 
            "      \"temperature\": [\r\n" + 
            "        null,\r\n" + 
            "        37,\r\n" + 
            "        60,\r\n" + 
            "        40,\r\n" + 
            "        64,\r\n" + 
            "        40,\r\n" + 
            "        43,\r\n" + 
            "        19,\r\n" + 
            "        30,\r\n" + 
            "        21,\r\n" + 
            "        42,\r\n" + 
            "        27\r\n" + 
            "      ],\r\n" + 
            "      \"temperatureHeatIndex\": [\r\n" + 
            "        null,\r\n" + 
            "        44,\r\n" + 
            "        58,\r\n" + 
            "        54,\r\n" + 
            "        62,\r\n" + 
            "        55,\r\n" + 
            "        42,\r\n" + 
            "        29,\r\n" + 
            "        29,\r\n" + 
            "        27,\r\n" + 
            "        40,\r\n" + 
            "        37\r\n" + 
            "      ],\r\n" + 
            "      \"temperatureWindChill\": [\r\n" + 
            "        null,\r\n" + 
            "        32,\r\n" + 
            "        35,\r\n" + 
            "        38,\r\n" + 
            "        38,\r\n" + 
            "        37,\r\n" + 
            "        20,\r\n" + 
            "        13,\r\n" + 
            "        14,\r\n" + 
            "        16,\r\n" + 
            "        17,\r\n" + 
            "        23\r\n" + 
            "      ],\r\n" + 
            "      \"thunderCategory\": [\r\n" + 
            "        null,\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\",\r\n" + 
            "        \"No thunder\"\r\n" + 
            "      ],\r\n" + 
            "      \"thunderIndex\": [\r\n" + 
            "        null,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0,\r\n" + 
            "        0\r\n" + 
            "      ],\r\n" + 
            "      \"uvDescription\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Moderate\",\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Moderate\",\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Moderate\",\r\n" + 
            "        \"Low\",\r\n" + 
            "        \"Moderate\",\r\n" + 
            "        \"Low\"\r\n" + 
            "      ],\r\n" + 
            "      \"uvIndex\": [\r\n" + 
            "        null,\r\n" + 
            "        0,\r\n" + 
            "        5,\r\n" + 
            "        0,\r\n" + 
            "        5,\r\n" + 
            "        0,\r\n" + 
            "        2,\r\n" + 
            "        0,\r\n" + 
            "        4,\r\n" + 
            "        0,\r\n" + 
            "        5,\r\n" + 
            "        0\r\n" + 
            "      ],\r\n" + 
            "      \"windDirection\": [\r\n" + 
            "        null,\r\n" + 
            "        8,\r\n" + 
            "        359,\r\n" + 
            "        242,\r\n" + 
            "        185,\r\n" + 
            "        341,\r\n" + 
            "        353,\r\n" + 
            "        36,\r\n" + 
            "        59,\r\n" + 
            "        336,\r\n" + 
            "        60,\r\n" + 
            "        216\r\n" + 
            "      ],\r\n" + 
            "      \"windDirectionCardinal\": [\r\n" + 
            "        null,\r\n" + 
            "        \"N\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"WSW\",\r\n" + 
            "        \"S\",\r\n" + 
            "        \"NNW\",\r\n" + 
            "        \"N\",\r\n" + 
            "        \"NE\",\r\n" + 
            "        \"ENE\",\r\n" + 
            "        \"NNW\",\r\n" + 
            "        \"ENE\",\r\n" + 
            "        \"SW\"\r\n" + 
            "      ],\r\n" + 
            "      \"windPhrase\": [\r\n" + 
            "        null,\r\n" + 
            "        \"N winds at 10 to 20 mph, decreasing to 5 to 10 mph.\",\r\n" + 
            "        \"Winds N at 5 to 10 mph.\",\r\n" + 
            "        \"Winds WSW at 5 to 10 mph.\",\r\n" + 
            "        \"Winds S at 10 to 20 mph.\",\r\n" + 
            "        \"Winds NNW at 10 to 15 mph.\",\r\n" + 
            "        \"Winds N at 15 to 25 mph.\",\r\n" + 
            "        \"Winds NE at 10 to 20 mph.\",\r\n" + 
            "        \"Winds ENE at 10 to 15 mph.\",\r\n" + 
            "        \"Winds NNW at 5 to 10 mph.\",\r\n" + 
            "        \"Winds ENE at 5 to 10 mph.\",\r\n" + 
            "        \"Winds SW at 5 to 10 mph.\"\r\n" + 
            "      ],\r\n" + 
            "      \"windSpeed\": [\r\n" + 
            "        null,\r\n" + 
            "        16,\r\n" + 
            "        9,\r\n" + 
            "        8,\r\n" + 
            "        14,\r\n" + 
            "        10,\r\n" + 
            "        19,\r\n" + 
            "        13,\r\n" + 
            "        10,\r\n" + 
            "        9,\r\n" + 
            "        8,\r\n" + 
            "        7\r\n" + 
            "      ],\r\n" + 
            "      \"wxPhraseLong\": [\r\n" + 
            "        null,\r\n" + 
            "        \"Mostly Cloudy\",\r\n" + 
            "        \"Partly Cloudy\",\r\n" + 
            "        \"Partly Cloudy\",\r\n" + 
            "        \"Mostly Sunny\",\r\n" + 
            "        \"Showers\",\r\n" + 
            "        \"Rain/Snow\",\r\n" + 
            "        \"Snow Early\",\r\n" + 
            "        \"PM Snow Showers\",\r\n" + 
            "        \"Snow Early\",\r\n" + 
            "        \"Partly Cloudy\",\r\n" + 
            "        \"Partly Cloudy\"\r\n" + 
            "      ],\r\n" + 
            "      \"wxPhraseShort\": [\r\n" + 
            "        null,\r\n" + 
            "        \"M Cloudy\",\r\n" + 
            "        \"P Cloudy\",\r\n" + 
            "        \"P Cloudy\",\r\n" + 
            "        \"M Sunny\",\r\n" + 
            "        \"Showers\",\r\n" + 
            "        \"Rain/Snow\",\r\n" + 
            "        \"Snow Early\",\r\n" + 
            "        \"PM Snw Shwrs\",\r\n" + 
            "        \"Snow Early\",\r\n" + 
            "        \"P Cloudy\",\r\n" + 
            "        \"P Cloudy\"\r\n" + 
            "      ]\r\n" + 
            "    }\r\n" + 
            "  ]\r\n" + 
            "}";
    
    @Test
    void testParse5DayJSON() {
        CallWUAPI testJSON = new CallWUAPI();
        try {
            ArrayList<DailyForecast> forecast = testJSON.parse5DayJSON(jsonTestResponse);
            
            ArrayList<String> daysOfWeek = new ArrayList<String>();
            ArrayList<String> date = new ArrayList<String>();
            ArrayList<String> mainNarr = new ArrayList<String>();
            
            // START OF TWO PER DAY ELEMENTS
            ArrayList<String> dayPrtD = new ArrayList<String>();
            ArrayList<String> dayPrtN = new ArrayList<String>();
            
            for (int i = 0; i < forecast.size(); i++) {
                DailyForecast day = forecast.get(i);
                
                String dateString = day.getDate();
                date.add(dateString);
                
                String dayName = day.getDayOfWeek();
                daysOfWeek.add(dayName);
                
                String narrMain = day.getNarrative();
                mainNarr.add(narrMain);
                
                // START OF TWO PER DAY ELEMENTS
                String dayPartD = day.getDaypartNameD();
                dayPrtD.add(dayPartD);
                
                String dayPartN = day.getDaypartNameN();
                dayPrtN.add(dayPartN);
                
            }
            String dateTest = date.toString();
            assertEquals(dateTest, "[2020-03-16, 2020-03-17, 2020-03-18, 2020-03-19, 2020-03-20, 2020-03-21]");
            
            String daysTest = daysOfWeek.toString();
            assertEquals(daysTest, "[Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]");
            
            String narrTest = mainNarr.toString();
            assertEquals(narrTest, "[Considerable cloudiness. Lows overnight in the upper 30s., "
                    + "Mix of sun and clouds. Highs in the low 60s and lows in the low 40s., "
                    + "Plenty of sun. Highs in the mid 60s and lows in the low 40s., "
                    + "Rain mixed with snow. Highs in the low 40s and lows in the upper teens., "
                    + "Snow showers developing in the afternoon. Highs in the low 30s and lows in the low 20s., "
                    + "Partly cloudy. Highs in the low 40s and lows in the upper 20s.]");
            
            // START OF TWO PER DAY ELEMENTS
            String dayPartDTest = dayPrtD.toString();
            assertEquals(dayPartDTest, "[XX, Tomorrow, Wednesday, Thursday, Friday, Saturday]");
            
            String dayPartNTest = dayPrtN.toString();
            assertEquals(dayPartNTest, "[Tonight, Tomorrow night, Wednesday night, Thursday night, Friday night, Saturday night]");
            
            
            
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        
    }

}
