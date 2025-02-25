package org.yearobjectives.infrastructure.database.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.infrastructure.database.entity.ObjectiveEntity;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ObjectiveRepository implements PanacheRepository<ObjectiveEntity> {


    public Optional<ObjectiveEntity> findByResourceId(final UUID objectiveId) {
        return find("resourceId", objectiveId).firstResultOptional();
    }
}
