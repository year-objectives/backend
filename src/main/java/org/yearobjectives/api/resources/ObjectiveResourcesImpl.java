package org.yearobjectives.api.resources;

import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.api.resources.utils.ResponseHelper;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import org.yearobjectives.domain.service.ObjectiveService;

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

}
