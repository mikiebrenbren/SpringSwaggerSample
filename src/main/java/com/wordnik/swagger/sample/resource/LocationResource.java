package com.wordnik.swagger.sample.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.sample.exception.NotFoundException;
import com.wordnik.swagger.sample.model.Hipster;
import com.wordnik.swagger.sample.model.Location;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by michael.brennan on 1/28/15.
 */

@Path("/location")
@Api(value = "/location", description = "Operations about locations")
@Produces({"application/json", "application/xml"})

public interface LocationResource {

    @GET
    @ApiOperation(value = "gives current location", notes = "Returns the location of the hipster")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Location not found")})
    Location getLocationByCity(
            @PathParam("location") String hipsterId)
            throws NotFoundException;


}
