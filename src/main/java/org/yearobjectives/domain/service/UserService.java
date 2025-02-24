package org.yearobjectives.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.yearobjectives.api.dto.UserDto;
import org.yearobjectives.domain.assembler.UserAssembler;
import org.yearobjectives.infrastructure.database.entity.UserEntity;
import org.yearobjectives.infrastructure.database.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class UserService {

    @Inject
    UserAssembler userAssembler;

    @Inject
    UserRepository userRepository;

    @Transactional
    public UserDto registerUser(final String userName) {
        final AtomicReference<UserDto> userDto = new AtomicReference<>();
        final Optional<UserEntity> userEntity = userRepository.findByName( userName);
        userEntity.ifPresentOrElse(user -> {
            userDto.set(userAssembler.toApi(userAssembler.fromEntity(user)));
        }, () -> {
            UserEntity newUser = new UserEntity(userName, UUID.randomUUID());
            userRepository.persist(newUser);
            userDto.set(userAssembler.toApi(userAssembler.fromEntity(newUser)));
        });
        return userDto.get();
    }
}
