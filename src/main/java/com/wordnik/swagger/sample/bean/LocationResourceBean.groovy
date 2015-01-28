package com.wordnik.swagger.sample.bean

import com.wordnik.swagger.sample.data.LocationData
import com.wordnik.swagger.sample.exception.NotFoundException
import com.wordnik.swagger.sample.model.Hipster
import com.wordnik.swagger.sample.model.Location
import com.wordnik.swagger.sample.resource.LocationResource
import org.springframework.stereotype.Component

import javax.ws.rs.PathParam

/**
 * Created by michael.brennan on 1/28/15.
 */
@Component
class LocationResourceBean implements LocationResource{

    @Override
    Location getLocationByCity(@PathParam("location") String hipsterId) throws NotFoundException {
        def location = LocationData.getLocationByState()
        return null
    }
}
