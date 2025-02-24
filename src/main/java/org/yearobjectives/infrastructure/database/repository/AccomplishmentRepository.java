package org.yearobjectives.infrastructure.database.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.infrastructure.database.entity.AccomplishmentEntity;

@ApplicationScoped
public class AccomplishmentRepository implements PanacheRepository<AccomplishmentEntity> {

}
