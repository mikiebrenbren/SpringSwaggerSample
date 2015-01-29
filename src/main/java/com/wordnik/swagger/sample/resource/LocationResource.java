package com.wordnik.swagger.sample.resource;

import com.wordnik.swagger.annotations.*;
import com.wordnik.swagger.sample.exception.NotFoundException;
import com.wordnik.swagger.sample.model.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by michael.brennan on 1/28/15.
 */

@Path("/location")
@Api(value = "/location", description = "Operations about locations")
@Produces({"application/json", "application/xml"})

public interface LocationResource {

    @GET
    @Path("/{state}")
    @ApiOperation(value = "gives current location", notes = "Returns the location of the hipster")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Location not found")})
    Location getLocationByState(
            @PathParam("state") String hipsterId)
            throws NotFoundException;

//    @POST
//    @ApiOperation(value = "Add a new location to the store")
//    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
//    Response addLocation(
//            @ApiParam(value = "Location object that needs to be added to the store", required = true) String city, String state,
//    String zip, String country);


    @POST
    @ApiOperation(value = "Add a new store location")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    Response addLocation(
            @ApiParam(value = "Location object that needs to be added to the store", required = true) Location location);
}
