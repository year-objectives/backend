package org.yearobjectives.api.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.domain.service.ObjectiveService;

import java.net.URI;
import java.util.UUID;

public class ObjectiveResourcesImpl implements ObjectiveResources {

    @Inject
    ObjectiveService objectivesService;

    @Override
    public Response createObjective(String userName, ObjectiveInputDto objectiveInputDto) {
        ObjectiveDto objectiveDto = objectivesService.createObjective(userName, objectiveInputDto);
        return Response.created(URI.create(Paths.OBJECTIVES+"/" + objectiveDto.id())).entity(objectiveDto).build();
    }
}
