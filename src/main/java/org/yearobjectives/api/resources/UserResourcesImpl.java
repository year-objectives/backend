package org.yearobjectives.api.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.yearobjectives.domain.service.UserService;

public class UserResourcesImpl implements UserResources {

    @Inject
    UserService userService;

    @Override
    public Response registerUser(final String userName) {
        return Response.status(201).entity(userService.registerUser(userName)).build();
    }
}
