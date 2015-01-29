package com.wordnik.swagger.sample.data;

import com.wordnik.swagger.sample.model.Hipster;
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

    public static Location createLocation(String city, String state, String zip, String country){

        Location location = new Location();

        location.setCity(city);
        location.setState(state);
        location.setZip(zip);
        location.setCountry(country);

        return location;
    }

    public static Location getLocationByState(String state){
        for(Location location:locationsList){
            if(location.getState().equals(state)) {
                return location;
            }
        }
        return null;
    }

    public static void addLocation(Location location){
        locationsList.add(location);
    }

    public static void main (String args[]){

        System.out.println(getLocationByState("utah").getState());
        Location location = new Location();
        location.setCity("san diego");
        location.setCountry("us");
        location.setZip("84106");
        location.setState("ca");
        locationsList.add(location);

        System.out.print(locationsList.get(1).getCity().equals("san diego"));
    }


}
