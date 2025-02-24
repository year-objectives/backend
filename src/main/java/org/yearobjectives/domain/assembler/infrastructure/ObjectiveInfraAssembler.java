package org.yearobjectives.domain.assembler.infrastructure;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.yearobjectives.domain.entity.MarkerType;
import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.domain.entity.Objective.Marker;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectives;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectivesDone;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObjectiveInfraAssembler {


    public List<Objective> fromEntity(final List<DynamoObjectives> objectives) {
        return Optional.ofNullable(objectives)
                .map(entities -> entities.stream().map(this::fromEntity).collect(Collectors.toList()))
                .orElse(null);
    }

    public Objective fromEntity(final DynamoObjectives objective) {
        return null;
    }

    public DynamoObjectives fromDomain(Objective objective) {
        return Optional.ofNullable(objective)
                .map(this::convertAfterValidation)
                .orElse(null);
    }

    private DynamoObjectives convertAfterValidation(Objective objective) {
        final DynamoObjectives dynamoObjectives = new DynamoObjectives();
        dynamoObjectives.setId(objective.id().toString());
        dynamoObjectives.setType(objective.type().name());
        dynamoObjectives.setCellAmount(objective.cellAmount());
        dynamoObjectives.setReversible(objective.reversible());
        dynamoObjectives.setCreatedAt(objective.startAt().getEpochSecond());
        dynamoObjectives.setUser(objective.user());
        return dynamoObjectives;
    }

    public Objective fromInfra(DynamoObjectives dynamoObjective) {
        return Optional.ofNullable(dynamoObjective)
        .map(obj -> new Objective(UUID.fromString(obj.getId()), MarkerType.valueOf(obj.getType()), obj.getReversible(), null, obj.getCellAmount(), Instant.ofEpochSecond(obj.getCreatedAt()), obj.getUser()))
        .orElse(null);
    }

    public DynamoObjectivesDone fromDomain(Marker fromApi) {
        DynamoObjectivesDone dynamoObjectiveDone = null;
        if(Objects.nonNull(fromApi)) {
            dynamoObjectiveDone = new DynamoObjectivesDone();
            dynamoObjectiveDone.setEndsAt(fromApi.endsAt().getEpochSecond());
            dynamoObjectiveDone.setstartsAt(fromApi.startsAt().getEpochSecond());
            dynamoObjectiveDone.setId(UUID.randomUUID().toString());
            dynamoObjectiveDone.setParentId(fromApi.parentId().toString());

        }
        return dynamoObjectiveDone;
    }

}
