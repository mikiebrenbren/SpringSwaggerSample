package com.wordnik.swagger.sample.bean

import com.wordnik.swagger.sample.data.LocationData
import com.wordnik.swagger.sample.exception.NotFoundException
import com.wordnik.swagger.sample.model.Location
import com.wordnik.swagger.sample.resource.LocationResource
import org.springframework.stereotype.Component

import javax.ws.rs.PathParam
import javax.ws.rs.core.Response;

/**
 * Created by michael.brennan on 1/28/15.
 */
@Component
class LocationResourceBean implements LocationResource{

    @Override
    Location getLocationByState(@PathParam("location") String state) throws NotFoundException {
        def location = LocationData.getLocationByState()
        if(state != null){
            return location
        } else {
            throw new NotFoundException(404, "Location unknown")
        }
    }

    @Override
    public Response addLocation(Location location) {
        LocationData.addLocation(location);
        return Response.ok().entity("SUCCESS").build();
    }
}
