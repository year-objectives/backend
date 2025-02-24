package org.yearobjectives.domain.assembler;

import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.api.dto.UserDto;
import org.yearobjectives.domain.entity.User;
import org.yearobjectives.infrastructure.database.entity.UserEntity;

import java.util.Optional;

@ApplicationScoped
public class UserAssembler {

    public User fromEntity(UserEntity entity) {
        return Optional.ofNullable(entity).map(userEntity -> new User(userEntity.getResourceId(), userEntity.getName())).orElse(null);
    }

    public UserDto toApi(User user) {
        return Optional.ofNullable(user).map(usr -> new UserDto(usr.id(), usr.name())).orElse(null);
    }

}
