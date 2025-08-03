package org.yearobjectives.api.resources;

import org.yearobjectives.api.dto.AuthDto;
import org.yearobjectives.api.dto.UserRegisterDto;
import org.yearobjectives.domain.service.AuthenticationService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;

public class AuthResourcesImpl implements AuthResources {

    @Inject
    AuthenticationService authenticationService;

    @Override
    public Response registerUser(@Valid UserRegisterDto userRegisterDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }

    @Override
    public Response loginUser(@Valid AuthDto authDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
    }

}
