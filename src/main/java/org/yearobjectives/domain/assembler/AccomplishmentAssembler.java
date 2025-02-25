package org.yearobjectives.domain.assembler;

import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.api.dto.AccomplishmentDto;
import org.yearobjectives.domain.entity.Accomplishment;
import org.yearobjectives.infrastructure.database.entity.AccomplishmentEntity;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccomplishmentAssembler {


    public List<Accomplishment> fromEntity(List<AccomplishmentEntity> entity) {
        return Optional.ofNullable(entity).map(accomplishmentEntities -> accomplishmentEntities.stream().map(this::fromEntity).toList())
                .orElse(null);
    }

    public Accomplishment fromEntity(AccomplishmentEntity entity) {
        return Optional.ofNullable(entity).map(accomplishmentEntity ->
                new Accomplishment(accomplishmentEntity.getResourceId(), Optional.ofNullable(accomplishmentEntity.getDone()).orElse(true), Instant.ofEpochSecond(accomplishmentEntity.getDoneAt())))
                .orElse(null);
    }

    public List<AccomplishmentDto> toApi(List<Accomplishment> accomplishments) {
        return Optional.ofNullable(accomplishments).map(accs -> accs.stream().map(this::toApi).toList())
                .orElse(null);
    }

    public AccomplishmentDto toApi(Accomplishment accomplishment) {
        return Optional.ofNullable(accomplishment).map(acc -> new AccomplishmentDto(acc.resourceId(), acc.done(), acc.concludedAt().getEpochSecond())).orElse(null);
    }

}
