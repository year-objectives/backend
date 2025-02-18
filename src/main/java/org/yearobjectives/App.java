package org.yearobjectives;

import jakarta.ws.rs.ApplicationPath;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.AppUtils.ResponseDto;
import org.yearobjectives.api.dto.ObjectiveDto;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@ApplicationPath(Paths.ROOT_PATH)
@OpenAPIDefinition(
        info = @Info(
                title = "Yearly objectives API",
                description = "Service API that allow consult and manage yearly objectives.",
                version = "1.0.0"
        ),

        servers = {
                @Server(
                        description = "Yearly Objectives",
                        url = "/"
                )
        },
        components = @Components(
                responses = {
                        @APIResponse(
                                name = ResponseDto.OBJECTIVE,
                                description = "Objective success response.",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(ref = ResponseDto.OBJECTIVE))),
                        @APIResponse(
                                name = ResponseDto.OBJECTIVE_LIST,
                                description = "List of objectives success response.",
                                content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(type= SchemaType.ARRAY, implementation = ObjectiveDto.class)))
                }
        )
)
public class App extends Application {
}
