package org.yearobjectives.api.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.api.dto.AuthDto;
import org.yearobjectives.api.dto.UserRegisterDto;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Tag(name = "Authentication Api", description = "The API to handle Authentication Resource.")
@Path(Paths.AUTH)
@Produces(MediaType.APPLICATION_JSON)
public interface AuthResources {

    
    @POST
    @Path("/register")
    @PermitAll
    @Operation(summary = "Registers a user", description = "Registers a user",
            operationId = "registerUser")
    @APIResponse(responseCode = "201")
    Response registerUser(@Valid UserRegisterDto userRegisterDto);
    
    
    @POST
    @Path("/login")
    @PermitAll
    @Operation(summary = "Registers a user", description = "Registers a user",
    operationId = "registerUser")
    @APIResponse(responseCode = "201")
    Response loginUser(@Valid AuthDto authDto);
}
