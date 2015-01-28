package com.wordnik.swagger.sample.data;

import com.wordnik.swagger.sample.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael.brennan on 1/28/15.
 */
public class LocationData  {

    static List<Location> locationsList = new ArrayList<Location>();


    static{

        locationsList.add(createLocation("salt lake city", "utah", "zip", "united states"));

    }



    static Location createLocation(String city, String state, String zip, String country){

        Map hashMap = new HashMap();

        hashMap.put("city", city);
        hashMap.put("state", state);
        hashMap.put("zip", zip);
        hashMap.put("country", country);

        Location location = new Location(hashMap);
        return location;
    }

    public static Location getLocationByState(String state){
        for(Location location:locationsList){
            if(locationsList.contains(state))
                return location;
        }
        return null;
    }
}
