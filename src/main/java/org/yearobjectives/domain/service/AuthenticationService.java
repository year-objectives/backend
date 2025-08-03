package org.yearobjectives.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.yearobjectives.api.dto.UserRegisterDto;
import org.yearobjectives.domain.assembler.UserAssembler;
import org.yearobjectives.infrastructure.database.entity.UserEntity;
import org.yearobjectives.infrastructure.database.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class AuthenticationService {

    @Inject
    UserAssembler userAssembler;

    @Inject
    UserRepository userRepository;

    @Inject
    @ConfigProperty(name = "password.salt")
    String salt;

    @Transactional
    public void registerUser(final UserRegisterDto userToRegister) {

        
    }
}
