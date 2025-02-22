package org.yearobjectives.domain.assembler.infrastructure;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.domain.entity.Objective.Marker;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectives;

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
        // final List<DynamoMarker> markes = Optional.ofNullable(objective.objectiveMarkers())
        // .map(markers -> markers.stream().map(this::fromDomain).toList()).orElse(null);
        dynamoObjectives.setId(objective.id().toString());
        dynamoObjectives.setType(objective.type().name());
        dynamoObjectives.setCellAmount(objective.cellAmount());
        dynamoObjectives.setReversible(objective.reversible());
        dynamoObjectives.setCreatedAt(objective.startAt().getEpochSecond());
        dynamoObjectives.setUser(objective.user());
        // dynamoObjectives.setMarkers(markes);
        return dynamoObjectives;
    }

    public Objective fromInfra(DynamoObjectives dynamoObjective) {
        return new Objective(UUID.fromString(dynamoObjective.getId()), Objective.Type.valueOf(dynamoObjective.getType()), dynamoObjective.getReversible(), null, dynamoObjective.getCellAmount(), Instant.ofEpochSecond(dynamoObjective.getCreatedAt()), dynamoObjective.getUser());
    }

    // private DynamoMarker fromDomain(final Marker marker) {
    //     return Optional.ofNullable(marker)
    //     .map(mkr -> new DynamoMarker(mkr.done(), mkr.concludedAt())) 
    //     .orElse(null);
    // }

}
