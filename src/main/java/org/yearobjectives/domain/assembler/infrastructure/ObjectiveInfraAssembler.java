package org.yearobjectives.domain.assembler.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.yearobjectives.domain.entity.Objective;
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

}
