package org.yearobjectives.api.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.yearobjectives.AppUtils.Headers;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.AppUtils.ResponseDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;

@Tag(name = "Objectives Api", description = "The API to handle Objectives Resource.")
@Path(Paths.OBJECTIVES)
@Produces(MediaType.APPLICATION_JSON)
public interface ObjectiveResources {

    // Drop header param as soon as auth implementation is in place and user info comes from login
    @POST
    @Operation(summary = "Creates an objective", description = "Creates an objective",
            operationId = "createObjective")
    @APIResponse(responseCode = "201", ref = ResponseDto.OBJECTIVE)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response createObjective(@Parameter(ref = Headers.USER) @HeaderParam(Headers.USER) String userName, @Valid ObjectiveInputDto objectiveInputDto);

}
