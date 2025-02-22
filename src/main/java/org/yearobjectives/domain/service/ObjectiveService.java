package org.yearobjectives.domain.service;

import java.util.List;

import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.domain.assembler.api.ObjectiveApiAssembler;
import org.yearobjectives.domain.assembler.infrastructure.ObjectiveInfraAssembler;
import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.infrastructure.client.dynamodb.ObjectivesClient;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectives;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ObjectiveService {

    @Inject
    private ObjectivesClient objectivesClient;

    @Inject
    private ObjectiveApiAssembler objectiveApiAssembler;

    @Inject
    private ObjectiveInfraAssembler objectiveInfraAssembler;

    public ObjectiveDto createObjective(ObjectiveInputDto objectiveInputDto) {
        final Objective domainObjective = objectiveApiAssembler.fromApi(objectiveInputDto);
        final DynamoObjectives objective = objectiveInfraAssembler.fromDomain(domainObjective);
        objectivesClient.create(objective);
        return objectiveApiAssembler.fromDomain(domainObjective);
    }

    public ObjectiveDto getById(String id) {
        return objectiveApiAssembler.fromDomain(objectiveInfraAssembler.fromInfra(objectivesClient.getById(id)));
    }
}
