package org.yearobjectives.infrastructure.database.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.infrastructure.database.entity.UserEntity;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {


    public Optional<UserEntity> findByName(String userName) {
        return find("name", userName).firstResultOptional();
    }

}
