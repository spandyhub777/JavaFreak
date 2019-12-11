package com.flight.simpleFlightSearch.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flight.simpleFlightSearch.service.FlightService;



@Service
public class FlightServiceImpl implements FlightService{

	
	public JSONObject flightDataFromJson(String numberFl)
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject myList = null;
        
        try (FileReader reader = new FileReader("//Users//Chinthy//git//simpleFlightSearch//flight-docs//flight-sample.json"))
        {
            //Read JSON file
        	Object obj = jsonParser.parse(reader);
 
            JSONArray flightList = (JSONArray) obj;
            
            Iterator iterator = flightList.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject1 = ((JSONObject) iterator.next());
                Iterator<? extends Map.Entry<Object, Object> > it = jsonObject1.entrySet().iterator();
                while(it.hasNext()) {
                	
                	if(it.next().getValue().equals(numberFl))
                	{
                		myList = jsonObject1;
                		System.out.println("iterator element : "+jsonObject1.entrySet());
                	}
//                	Map.Entry<Object, Object> pair = it.next();
//                	String name = null;
//                    if(pair.getKey().equals("name")){
//                        name = (String) pair.getValue();
//                    }
                }
            }
//            if(flightList.contains(numberFl))
//            	return flightList.indexOf(numberFl);
//            for (int i = 0; i < flightList.size(); ++i) {
//            	
//                JSONObject jsn = flightList.getJSONObject(i);
//
//               String keyVal = jsn.getString("numberFl");
//            }
             
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myList;
	}
}

