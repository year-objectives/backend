package org.yearobjectives.infrastructure.database.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.infrastructure.database.entity.AccomplishmentEntity;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AccomplishmentRepository implements PanacheRepository<AccomplishmentEntity> {

    public List<AccomplishmentEntity> getCurrentAccomplishments(final UUID objectiveId, final Long currentTimeStamp) {
        return list("objective.resourceId = ?1 and maxPossibleStart > ?2 and minPossibleStart <= ?2", objectiveId, currentTimeStamp);
    }
}
