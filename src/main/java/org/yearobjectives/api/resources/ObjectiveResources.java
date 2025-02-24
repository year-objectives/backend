package org.yearobjectives.api.resources;

import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.AppUtils.Headers;
import org.yearobjectives.AppUtils.QueryParameters;
import org.yearobjectives.AppUtils.Parameters;
import org.yearobjectives.AppUtils.ResponseDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.api.dto.ObjectiveMarkerDto;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Objectives Api", description = "The API to handle Objectives Resource.")
@Path(Paths.OBJECTIVES)
@Produces(MediaType.APPLICATION_JSON)
public interface ObjectiveResources {

    @GET
    @Path(Paths.OBJECTIVE_ID)
    @Operation(summary = "Get objective by Id", description = "Gets objective by Id",
            operationId = "getObjectiveById")
    @APIResponse(responseCode = "200", ref = ResponseDto.OBJECTIVE)
    @APIResponse(responseCode = "204", ref = ResponseDto.NO_CONTENT)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response getById(@Parameter(ref = Parameters.OBJECTIVE_ID) @PathParam(Parameters.OBJECTIVE_ID) String id);

    // Drop header param as soon as auth implementation is in place and user info comes from login
    @POST
    @Operation(summary = "Creates an objective", description = "Creates an objective",
            operationId = "createObjective")
    @APIResponse(responseCode = "201", ref = ResponseDto.OBJECTIVE)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response createObjective(@Parameter(ref = Headers.USER) @HeaderParam(Headers.USER) String user, @Valid ObjectiveInputDto objectiveInputDto);

    @POST
    @Path(Paths.OBJECTIVE_ID)
    @Operation(summary = "Creates an objective entry", description = "Creates an objective entry",
            operationId = "createObjectiveEntry")
    @APIResponse(responseCode = "201", ref = ResponseDto.OBJECTIVE)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response createObjectiveEntry(@Parameter(ref = Headers.USER) 
                                  @HeaderParam(Headers.USER) 
                                  String user, 

                                  @Parameter(ref = Parameters.OBJECTIVE_ID) 
                                  @PathParam(Parameters.OBJECTIVE_ID) 
                                  UUID id,

                                  @Valid ObjectiveMarkerDto objectiveMarkerDto);

    @GET
    @Path(Paths.ENTRY_ID)
    @Operation(summary = "Get objective by Id", description = "Gets objective by Id",
            operationId = "getObjectiveById")
    @APIResponse(responseCode = "200", ref = ResponseDto.OBJECTIVE)
    @APIResponse(responseCode = "204", ref = ResponseDto.NO_CONTENT)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response getEntryById(@Parameter(ref = Parameters.ENTRY_ID) @PathParam(Parameters.ENTRY_ID) String id);
}
