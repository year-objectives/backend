package org.yearobjectives;

import jakarta.ws.rs.ApplicationPath;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.AppUtils.Headers;
import org.yearobjectives.AppUtils.Parameters;
import org.yearobjectives.AppUtils.ResponseDto;
import org.yearobjectives.api.dto.ObjectiveDto;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
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
                parameters = {
                        @Parameter(
                                name = Parameters.OBJECTIVE_ID,
                                description = Parameters.OBJECTIVE_ID,
                                in = ParameterIn.PATH,
                                example = "73cd881e-56c9-4465-903b-06b13392d300",
                                required = true,
                                schema = @Schema(type = SchemaType.STRING)),
                        @Parameter(
                                name = Parameters.ENTRY_ID,
                                description = Parameters.ENTRY_ID,
                                in = ParameterIn.PATH,
                                example = "73cd881e-56c9-4465-903b-06b13392d300",
                                required = true,
                                schema = @Schema(type = SchemaType.STRING)),
                        @Parameter(
                                name = Headers.USER,
                                description = Headers.USER,
                                in = ParameterIn.HEADER,
                                example = "maria",
                                schema = @Schema(type = SchemaType.STRING)),
                },
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
                                        schema = @Schema(type= SchemaType.ARRAY, implementation = ObjectiveDto.class))),
                        @APIResponse(
                                name = ResponseDto.NO_CONTENT,
                                description = "No Content Response.",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON)),
                        @APIResponse(
                                name = ResponseDto.BAD_REQUEST,
                                description = "Bad Request response.",
                                content = @Content(
                                        mediaType = MediaType.TEXT_PLAIN,
                                        schema = @Schema(name = ResponseDto.BAD_REQUEST,
                                                description = "Bad Request response object",
                                                type = SchemaType.STRING,
                                                readOnly = true,
                                                example = "Objective type can not be null"))),
                }
        )
)
public class App extends Application {
}
