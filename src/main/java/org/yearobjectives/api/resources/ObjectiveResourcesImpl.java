package org.yearobjectives.api.resources;

import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.api.dto.ObjectiveMarkerDto;
import org.yearobjectives.api.resources.utils.ResponseHelper;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.UUID;

import org.yearobjectives.domain.service.ObjectiveService;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectivesDone;

public class ObjectiveResourcesImpl implements ObjectiveResources {

    @Inject
    private ObjectiveService objectivesService;

    @Inject
    private ResponseHelper responseHelper;

    @Override
    public Response createObjective(String user, ObjectiveInputDto objectiveInputDto) {
        final ObjectiveDto objectiveDto = objectivesService.createObjective(objectiveInputDto);
        return Response.created(URI.create(objectiveDto.id().toString())).entity(objectiveDto).build();
    }

    @Override
    public Response getById(final String id) {
        final ObjectiveDto objectiveDto = objectivesService.getById(id);
        return responseHelper.build(objectiveDto).build();
    }

    @Override
    public Response createObjectiveEntry(String user, UUID id, @Valid ObjectiveMarkerDto objectiveMarkerDto) {
        final DynamoObjectivesDone objectiveDto = objectivesService.createObjectiveEntry(id, objectiveMarkerDto);
        return Response.ok().entity(objectiveDto).build();
    }

    @Override
    public Response getEntryById(String id) {
        final DynamoObjectivesDone objectiveDto = objectivesService.getEntryById(id);
        return responseHelper.build(objectiveDto).build();
    }

}
