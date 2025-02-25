package org.yearobjectives.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.yearobjectives.api.dto.AccomplishmentDto;
import org.yearobjectives.domain.assembler.AccomplishmentAssembler;
import org.yearobjectives.domain.entity.Accomplishment;
import org.yearobjectives.domain.entity.ObjectiveType;
import org.yearobjectives.infrastructure.database.entity.AccomplishmentEntity;
import org.yearobjectives.infrastructure.database.entity.ObjectiveEntity;
import org.yearobjectives.infrastructure.database.repository.AccomplishmentRepository;
import org.yearobjectives.infrastructure.database.repository.ObjectiveRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class AccomplishmentService {

    @Inject
    ObjectiveRepository objectiveRepository;

    @Inject
    AccomplishmentAssembler accomplishmentAssembler;

    @Inject
    AccomplishmentRepository accomplishmentRepository;

    @Transactional
    public AccomplishmentDto registerAccomplishment(final UUID objectiveId, final AccomplishmentDto accomplishmentDto) {
        final ObjectiveEntity objectiveEntity = validateExistentObjective(objectiveId);
        final ObjectiveType objectiveType = ObjectiveType.valueOf(objectiveEntity.getType());
        final AccomplishmentEntity accomplishmentEntity = new AccomplishmentEntity(objectiveEntity, UUID.randomUUID(), accomplishmentDto.concludedAt(), accomplishmentDto.done(), objectiveType.getStart().getEpochSecond(), objectiveType.getEnd().getEpochSecond());
        accomplishmentRepository.persist(accomplishmentEntity);
        final Accomplishment accomplishmentDomain  = accomplishmentAssembler.fromEntity(accomplishmentEntity);
        return accomplishmentAssembler.toApi(accomplishmentDomain);
    }

    public List<AccomplishmentDto> getCurrentAccomplishments(final UUID objectiveId) {
        validateExistentObjective(objectiveId);
        final Long currentTimeStamp = Instant.now().getEpochSecond();
        final List<AccomplishmentEntity> accomplishmentEntities = accomplishmentRepository.getCurrentAccomplishments(objectiveId, currentTimeStamp);
        final List<Accomplishment> accomplishments = accomplishmentAssembler.fromEntity(accomplishmentEntities);
        return accomplishmentAssembler.toApi(accomplishments);
    }

    private ObjectiveEntity validateExistentObjective(final UUID objectiveId) {
        return objectiveRepository.findByResourceId(objectiveId).orElseThrow(() -> new NotFoundException("Objective not found"));
    }
}
