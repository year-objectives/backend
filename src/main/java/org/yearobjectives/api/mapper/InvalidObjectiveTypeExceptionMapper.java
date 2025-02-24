package org.yearobjectives.api.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.yearobjectives.api.dto.exceptions.InvalidObjectiveTypeException;

@Provider
public class InvalidObjectiveTypeExceptionMapper implements ExceptionMapper<InvalidObjectiveTypeException> {

    @Override
    public Response toResponse(final InvalidObjectiveTypeException exception) {
        return Response.status(400).entity(exception.getMessage()).build();
    }
}