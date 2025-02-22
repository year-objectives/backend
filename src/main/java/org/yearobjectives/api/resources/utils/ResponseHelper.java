package org.yearobjectives.api.resources.utils;

import java.util.List;
import java.util.Objects;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class ResponseHelper {

    public ResponseBuilder buildFromList(final List<?> entities) {
        Status statusCode = entities.isEmpty() ? Response.Status.NO_CONTENT : Response.Status.OK;
        return Response.status(statusCode).entity(entities);
    }

    public ResponseBuilder build(final Object entity) {
        Status statusCode = Objects.isNull(entity) ? Response.Status.NO_CONTENT : Response.Status.OK;
        return Response.status(statusCode).entity(entity);
    }

}
