package org.yearobjectives.api.filter.request;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Context SecurityContext securityCtx;
    @Inject UserInformation userInformation;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        userInformation.setCurrentUser(new UserInformation.User(requestContext.getHeaderString("x-user")));
    }

}
