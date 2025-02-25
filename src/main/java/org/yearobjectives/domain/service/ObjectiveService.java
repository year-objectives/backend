package org.yearobjectives.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.yearobjectives.api.dto.AccomplishmentDto;
import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.domain.assembler.AccomplishmentAssembler;
import org.yearobjectives.domain.assembler.ObjectiveAssembler;
import org.yearobjectives.domain.entity.Accomplishment;
import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.domain.entity.ObjectiveType;
import org.yearobjectives.infrastructure.database.entity.AccomplishmentEntity;
import org.yearobjectives.infrastructure.database.entity.ObjectiveEntity;
import org.yearobjectives.infrastructure.database.entity.UserEntity;
import org.yearobjectives.infrastructure.database.repository.AccomplishmentRepository;
import org.yearobjectives.infrastructure.database.repository.ObjectiveRepository;
import org.yearobjectives.infrastructure.database.repository.UserRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class ObjectiveService {

    @Inject
    ObjectiveRepository objectiveRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    ObjectiveAssembler objectiveAssembler;

    @Transactional
    public ObjectiveDto createObjective(final String userName, final ObjectiveInputDto objectiveInputDto) {
        final Optional<UserEntity> userEntity = userRepository.findByName(userName);
        final AtomicReference<Objective> objectiveDomain = new AtomicReference<>();
        userEntity.ifPresentOrElse(user -> {
            final ObjectiveEntity objectiveEntity = new ObjectiveEntity(UUID.randomUUID(), objectiveInputDto.type().name(), objectiveInputDto.reversible(), objectiveInputDto.cellAmount(), Instant.now().toEpochMilli(), user);
            objectiveRepository.persist(objectiveEntity);
            objectiveDomain.set(objectiveAssembler.fromEntity(objectiveEntity));
            },
            () -> {
            throw new NotFoundException("User not found");
        });
        return objectiveAssembler.toApi(objectiveDomain.get());
    }

}
