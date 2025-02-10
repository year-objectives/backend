package org.yearobjectives.api.resources;

import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.AppUtils.ResponseDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Objectives Api", description = "The API to handle Objectives Resource.")
@Path(Paths.OBJECTIVES)
@Produces(MediaType.APPLICATION_JSON)
public interface ObjectiveResources {

    @GET
    @Operation(summary = "Get all objectives", description = "Gets all objectives",
            operationId = "getObjectives")
    @APIResponse(responseCode = "200", ref = ResponseDto.OBJECTIVE_LIST)
    Response getAll();
}
