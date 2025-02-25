package org.yearobjectives.domain.assembler;

import jakarta.enterprise.context.ApplicationScoped;
import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveTypeDto;
import org.yearobjectives.api.dto.UserDto;
import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.domain.entity.ObjectiveType;
import org.yearobjectives.domain.entity.User;
import org.yearobjectives.infrastructure.database.entity.ObjectiveEntity;
import org.yearobjectives.infrastructure.database.entity.UserEntity;

import java.time.Instant;
import java.util.Optional;

@ApplicationScoped
public class ObjectiveAssembler {

    public Objective fromEntity(ObjectiveEntity entity) {
        return Optional.ofNullable(entity).map(objectiveEntity ->
                new Objective(objectiveEntity.getResourceId(), ObjectiveType.valueOf(objectiveEntity.getType()), objectiveEntity.getReversible(), objectiveEntity.getTargetAmount(), Instant.ofEpochSecond(objectiveEntity.getCreatedAt()), objectiveEntity.getUser().getName()))
                .orElse(null);
    }

    public ObjectiveDto toApi(Objective objective) {
        return Optional.ofNullable(objective).map(obj -> new ObjectiveDto(obj.id(), ObjectiveTypeDto.valueOf(obj.type().name()), objective.reversible())).orElse(null);
    }

}
