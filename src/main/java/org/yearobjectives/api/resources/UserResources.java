package org.yearobjectives.api.resources;

import jakarta.validation.constraints.NotEmpty;
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

@Tag(name = "Users Api", description = "The API to handle User Resource.")
@Path(Paths.USERS)
@Produces(MediaType.APPLICATION_JSON)
public interface UserResources {

    // Adapt registration mechanism after implementation of auth
    @POST
    @Operation(summary = "Registers a user", description = "Registers a user",
            operationId = "registerUser")
    @APIResponse(responseCode = "201", ref = ResponseDto.USER)
    @APIResponse(responseCode = "400", ref = ResponseDto.BAD_REQUEST)
    Response registerUser(@Parameter(ref = Headers.USER) @HeaderParam(Headers.USER) @NotEmpty String userName);
}
