package com.wordnik.swagger.sample.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.sample.exception.NotFoundException;
import com.wordnik.swagger.sample.model.Hipster;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hipster")
@Api(value = "/hipster", description = "Operations about Hipsters")
@Produces({"application/json", "application/xml"})
public interface HipsterResource {
    @GET
    @Path("/{hipsterId}")
    @ApiOperation(value = "Find hipster by ID",
            notes = "Returns a hipster when ID < 10.  ID > 10 or nonintegers will simulate API error conditions"
    )
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Hipster not found")})
    Hipster getHipsterById(
            @PathParam("hipsterId") String hipsterId)
            throws NotFoundException;

    @POST
    @ApiOperation(value = "Add a new hipster to the store")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    Response addHipster(
            @ApiParam(value = "Hipster object that needs to be added to the store", required = true) Hipster hipster);

    @PUT
    @ApiOperation(value = "Update an existing hipster")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Hipster not found"),
            @ApiResponse(code = 405, message = "Validation exception")})
    Response updateHipster(
            @ApiParam(value = "Hipster object that needs to be added to the store", required = true) Hipster hipster);

    @GET
    @Path("/findByStatus")
    @ApiOperation(value = "Finds Hipsters by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = Hipster.class,
            responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid status value")})
    Response findHipstersByStatus(
            @ApiParam(value = "Status values that need to be considered for filter", required = true, defaultValue = "available", allowableValues = "available,pending,sold", allowMultiple = true) @QueryParam("status") String status);

    @GET
    @Path("/findByTags")
    @ApiOperation(value = "Finds Hipsters by tags",
            notes = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.",
            response = Hipster.class,
            responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid tag value")})
    @Deprecated
    Response findHipstersByTags(
            @ApiParam(value = "Tags to filter by", required = true, allowMultiple = true) @QueryParam("tags") String tags);
}