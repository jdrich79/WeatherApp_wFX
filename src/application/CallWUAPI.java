package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CallWUAPI {
    
    
    
    public String makeAPICall(String coordinates) throws IOException {
        URL wUnderground;
        URLConnection yc;
        BufferedReader in;
        
        
        String endPoint = "https://api.weather.com";
        String path = "/v3/wx/forecast/daily/5day";
        //String geocode = "39.717,-104.9";
        String geocode = coordinates;
        String apiKey = "a5951eae4c0f4fb5951eae4c0f7fb544";
        String queryParams = "?geocode=" + geocode + "&units=e&language=en-US&format=json&apiKey=" + apiKey; 

        String fiveDayURL = endPoint + path + queryParams;  
        
        wUnderground = new URL(fiveDayURL);
        yc = wUnderground.openConnection();
        in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        
        String inputLine;
        
        StringBuffer response = new StringBuffer();
        //BufferedReader does not have a "hasNext" type method so this is how to check for 
        //more input
        //if it has more input append to the StringBuffer
        while ((inputLine   = in.readLine()) != null) {
            response.append(inputLine);
        }
     
        in.close();
        
        return response.toString(); 
        
    }
    
    public ArrayList<String> jArrayHelper (JSONArray jsonArray) {
        ArrayList<String> arrName = new ArrayList<String>();
        
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                arrName.add(jsonArray.get(i).toString());
                //System.out.println(jsonArray.get(i).toString());
                
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return arrName;
        
    }
    
    
    /**
     * 
     * Method to parse the Weather Underground JSON response string into the DailyForecast Class
     * @param jsonResponse
     * @return
     * @throws JSONException
     */
    public ArrayList<DailyForecast> parse5DayJSON(String jsonResponse) throws JSONException {
      //create a JSON object with the String response
        JSONObject jObj = new JSONObject(jsonResponse);
        
        /*
         * Creating a JSONArray object for each data point being collected for
         * the 'Weather' class
         */
        
        JSONArray jADate = jObj.getJSONArray("validTimeLocal");  // collecting to parse out the date
        JSONArray jADayWeek = jObj.getJSONArray("dayOfWeek");
        JSONArray jANarrMain = jObj.getJSONArray("narrative");
        JSONArray jATmpMax = jObj.getJSONArray("temperatureMax");
        JSONArray jATmpMin = jObj.getJSONArray("temperatureMin");
        
        /*
         * Day Parts - data is divided into two parts per day
         */
        JSONObject daypartObj = jObj.getJSONArray("daypart").getJSONObject(0); 
            /*
             *  'daypartObj' created to get data from a deeper level of JSON, 
             *  and to reduce amount of code needed to reach it 
             */

        JSONArray jADayPart = daypartObj.getJSONArray("daypartName");
        JSONArray jANarrDPart = daypartObj.getJSONArray("narrative");
        JSONArray jAPrecipCh = daypartObj.getJSONArray("precipChance");
        JSONArray jACloud = daypartObj.getJSONArray("cloudCover");  
        JSONArray jAPrcpType = daypartObj.getJSONArray("precipType");
        JSONArray jAQpfPrt = daypartObj.getJSONArray("qpf"); 
        JSONArray jASnowPrt = daypartObj.getJSONArray("qpfSnow"); 
        JSONArray jAHeatIndex = daypartObj.getJSONArray("temperatureHeatIndex"); 
        JSONArray jAWindChill = daypartObj.getJSONArray("temperatureWindChill"); 
        JSONArray jAWindPhrase = daypartObj.getJSONArray("windPhrase"); 
       
        
        /*
         * Begin the building of the ArrayList 'forecasts' of 'DailyForecast' objects
         */
        ArrayList<DailyForecast> forecasts = new ArrayList<DailyForecast>();
        
        /*
         * Once a day data points are iterated through and set to variables
         * with a basic for loop, to be feed into 'DailyForecast' constructor
         */
        
        for(int i = 0; i < jADayWeek.length(); i++) {
            String tempdate = jADate.getString(i);
            String date = tempdate.substring(0, 10); 
            // stripping date from 'validTimeLocal'
            
            String dow = jADayWeek.getString(i);
            String nar = jANarrMain.getString(i);
            
            String wSer = "WUnderground";
            
            /*
             * Temperature max becomes 'null' after 3pm
             * local time. To avoid errors with a null value 
             * in an Integer variable, the below if/else sets
             * 'null' value to the value of 989. That value can 
             * be caught later not display a Temp Max for this
             * part of the day.
             */
            Integer tMax = 989;
            if (jATmpMax.isNull(i)) {
                tMax = 989;
            } else {
            tMax = jATmpMax.getInt(i);
            }
            
            Integer tMin = jATmpMin.getInt(i);
            
            /*
             * For data points split between Day and Night
             * two variable are created to catch each value
             */
            String dayPrtD = "";
            String dayPrtN = "";
            String narrDay = "";
            String narrNight = "";
            Integer precipD = null;
            Integer precipN = null;  
            Integer cloudD = null;
            Integer cloudN = null;
            String precipTypeD = "";
            String precipTypeN = "";
            Double qpfD = null;
            Double qpfN = null;
            Double snowD = null;
            Double snowN = null;
            Integer heatIdxD = null;
            Integer heatIdxN = null;
            Integer windChlD = null;
            Integer windChlN = null;
            String windPhD = "";
            String windPhN = "";
            
            
            /*
             * Due to the data points have a Day and Night
             * value, a regular For Loop does not work properly.
             * To get the data into the right days, this series of 
             * If/Else statement were used to get the data into the 
             * correct days 'DailyForecast' object
             */
            if (i == 0) {
                // 'daypartName' can have a null value at [0]
                if (jADayPart.isNull(0)) {dayPrtD = "XX";}
                else {dayPrtD = jADayPart.getString(0);}
                
                dayPrtN = jADayPart.getString(1);
                
                
                // 'narrative' in the day part can have a null at [0]
                if (jANarrDPart.isNull(0)) {narrDay = "";}
                else {narrDay = jANarrDPart.getString(0);}
                
                narrNight = jANarrDPart.getString(1);
                
                
                // 'precipChance' can have a null at [0]
                if (jAPrecipCh.isNull(0)) {precipD = 0;}
                else {precipD = jAPrecipCh.getInt(0);}
                
                precipN = jAPrecipCh.getInt(1);
                
                
                // 'cloudCover' can have null at [0]
                if (jACloud.isNull(0)) {cloudD = 0;}
                else {cloudD = jACloud.getInt(0);}
                
                cloudD = jACloud.getInt(1);
                
                
                // 'precipType' can have null at [0]
                if (jAPrcpType.isNull(0)) {precipTypeD = "";}
                else {precipTypeD = jAPrcpType.getString(0);}
                
                precipTypeN = jAPrcpType.getString(1);
                
                
                // 'qpf' for day part can have null at [0]
                if (jAQpfPrt.isNull(0)) {qpfD = 0.0;}
                else {qpfD = jAQpfPrt.getDouble(0);}
                
                qpfN = jAQpfPrt.getDouble(1);
                
                
                // 'qpfSnow' can have null at [0]
                if (jASnowPrt.isNull(0)) {snowD = 0.0;}
                else {snowD = jASnowPrt.getDouble(0);}
                
                snowN = jASnowPrt.getDouble(1);

                
                // 'temperatureHeatIndex' can have null at [0]
                if (jAHeatIndex.isNull(0)) {heatIdxD = 0;}
                else {heatIdxD = jAHeatIndex.getInt(0);}
                heatIdxN = jAHeatIndex.getInt(1);
                
                
                // 'temperatureWindChill' can have null at [0]
                if (jAWindChill.isNull(0)) {windChlD = 0;}
                else {windChlD = jAWindChill.getInt(0);}
                
                windChlN = jAWindChill.getInt(1);
                
                
                // 'windPhrase' can have null at [0]
                if (jAWindPhrase.isNull(0)) {windPhD = "";}
                else {windPhD = jAWindPhrase.getString(0);}
                
                windPhN = jAWindPhrase.getString(1);
                
            }
            else if (i == 1) {
                dayPrtD = jADayPart.getString(2);
                dayPrtN = jADayPart.getString(3);
                narrDay = jANarrDPart.getString(2);
                narrNight = jANarrDPart.getString(3);
                precipD = jAPrecipCh.getInt(2);
                precipN = jAPrecipCh.getInt(3); 
                

                cloudD = jACloud.getInt(2);
                cloudN = jACloud.getInt(3);
                precipTypeD = jAPrcpType.getString(2);
                precipTypeN = jAPrcpType.getString(3);
                qpfD = jAQpfPrt.getDouble(2);
                qpfN = jAQpfPrt.getDouble(3);
                snowD = jASnowPrt.getDouble(2);
                snowN = jASnowPrt.getDouble(3);
                heatIdxD = jAHeatIndex.getInt(2);
                heatIdxN = jAHeatIndex.getInt(3);
                windChlD = jAWindChill.getInt(2);
                windChlN = jAWindChill.getInt(3);
                windPhD = jAWindPhrase.getString(2);
                windPhN = jAWindPhrase.getString(3);
                
            }
            else if (i == 2) {

                dayPrtD = jADayPart.getString(4);
                dayPrtN = jADayPart.getString(5);
                narrDay = jANarrDPart.getString(4);
                narrNight = jANarrDPart.getString(5);
                precipD = jAPrecipCh.getInt(4);
                precipN = jAPrecipCh.getInt(5);   
                
                cloudD = jACloud.getInt(4);
                cloudN = jACloud.getInt(5);
                precipTypeD = jAPrcpType.getString(4);
                precipTypeN = jAPrcpType.getString(5);
                qpfD = jAQpfPrt.getDouble(4);
                qpfN = jAQpfPrt.getDouble(5);
                snowD = jASnowPrt.getDouble(4);
                snowN = jASnowPrt.getDouble(5);
                heatIdxD = jAHeatIndex.getInt(4);
                heatIdxN = jAHeatIndex.getInt(5);
                windChlD = jAWindChill.getInt(4);
                windChlN = jAWindChill.getInt(5);
                windPhD = jAWindPhrase.getString(4);
                windPhN = jAWindPhrase.getString(5);
                
            }
            else if (i == 3) {
                dayPrtD = jADayPart.getString(6);
                dayPrtN = jADayPart.getString(7);
                narrDay = jANarrDPart.getString(6);
                narrNight = jANarrDPart.getString(7);
                precipD = jAPrecipCh.getInt(6);
                precipN = jAPrecipCh.getInt(7);    
                
                cloudD = jACloud.getInt(6);
                cloudN = jACloud.getInt(7);
                precipTypeD = jAPrcpType.getString(6);
                precipTypeN = jAPrcpType.getString(7);
                qpfD = jAQpfPrt.getDouble(6);
                qpfN = jAQpfPrt.getDouble(7);
                snowD = jASnowPrt.getDouble(6);
                snowN = jASnowPrt.getDouble(7);
                heatIdxD = jAHeatIndex.getInt(6);
                heatIdxN = jAHeatIndex.getInt(7);
                windChlD = jAWindChill.getInt(6);
                windChlN = jAWindChill.getInt(7);
                windPhD = jAWindPhrase.getString(6);
                windPhN = jAWindPhrase.getString(7);
                
            }
            else if (i == 4) {
                dayPrtD = jADayPart.getString(8);
                dayPrtN = jADayPart.getString(9);
                narrDay = jANarrDPart.getString(8);
                narrNight = jANarrDPart.getString(9);
                precipD = jAPrecipCh.getInt(8);
                precipN = jAPrecipCh.getInt(9);    
                
                cloudD = jACloud.getInt(8);
                cloudN = jACloud.getInt(9);
                precipTypeD = jAPrcpType.getString(8);
                precipTypeN = jAPrcpType.getString(9);
                qpfD = jAQpfPrt.getDouble(8);
                qpfN = jAQpfPrt.getDouble(9);
                snowD = jASnowPrt.getDouble(8);
                snowN = jASnowPrt.getDouble(9);
                heatIdxD = jAHeatIndex.getInt(8);
                heatIdxN = jAHeatIndex.getInt(9);
                windChlD = jAWindChill.getInt(8);
                windChlN = jAWindChill.getInt(9);
                windPhD = jAWindPhrase.getString(8);
                windPhN = jAWindPhrase.getString(9);
                
            }
            else if (i == 5) {
                dayPrtD = jADayPart.getString(10);
                dayPrtN = jADayPart.getString(11);
                narrDay = jANarrDPart.getString(10);
                narrNight = jANarrDPart.getString(11);
                precipD = jAPrecipCh.getInt(10);
                precipN = jAPrecipCh.getInt(11); 
                
                cloudD = jACloud.getInt(10);
                cloudN = jACloud.getInt(11);
                precipTypeD = jAPrcpType.getString(10);
                precipTypeN = jAPrcpType.getString(11);
                qpfD = jAQpfPrt.getDouble(10);
                qpfN = jAQpfPrt.getDouble(11);
                snowD = jASnowPrt.getDouble(10);
                snowN = jASnowPrt.getDouble(11);
                heatIdxD = jAHeatIndex.getInt(10);
                heatIdxN = jAHeatIndex.getInt(11);
                windChlD = jAWindChill.getInt(10);
                windChlN = jAWindChill.getInt(11);
                windPhD = jAWindPhrase.getString(10);
                windPhN = jAWindPhrase.getString(10);
            }

            DailyForecast fdf = new DailyForecast(wSer, date, dow, nar, tMax, tMin,
                    dayPrtD, dayPrtN, narrDay, narrNight, precipD, precipN, cloudD, cloudN,
                    precipTypeD, precipTypeN, qpfD, qpfN, snowD, snowN, 
                    heatIdxD, heatIdxN, windChlD, windChlN, windPhD, windPhN);
            forecasts.add(fdf);
            
            //this.weatherNarrative(fdf); // PRINTS THE NARRATIVES
            
        }
  
        return forecasts; 
    }
    
    
   
    
//    public static void main(String[] args) {
//
//        
//        CallWUAPI WuAPI = new CallWUAPI();
//        ArrayList<DailyForecast> forecast = new ArrayList<DailyForecast>();
//        
//        String jsonResponse;
//        try {
//            jsonResponse = WuAPI.makeAPICall();
//            forecast = WuAPI.parse5DayJSON(jsonResponse);   
//            
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

}
