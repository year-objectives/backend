package org.yearobjectives.domain.service;

import java.util.List;

import org.yearobjectives.api.dto.ObjectiveDTO;
import org.yearobjectives.domain.assembler.api.ObjectiveApiAssembler;
import org.yearobjectives.domain.assembler.infrastructure.ObjectiveInfraAssembler;
import org.yearobjectives.infrastructure.client.dynamodb.ObjectivesClient;

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

    public List<ObjectiveDTO> getAllObjectives() {
        return objectiveApiAssembler.fromDomain(objectiveInfraAssembler.fromEntity(objectivesClient.findAll()));
    }
}
