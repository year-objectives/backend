package org.yearobjectives.api.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.yearobjectives.AppUtils.Paths;
import org.yearobjectives.api.dto.AccomplishmentDto;
import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.api.resources.utils.ResponseHelper;
import org.yearobjectives.domain.service.AccomplishmentService;
import org.yearobjectives.domain.service.ObjectiveService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public class ObjectiveResourcesImpl implements ObjectiveResources {

    @Inject
    ObjectiveService objectivesService;

    @Inject
    AccomplishmentService accomplishmentService;

    @Inject
    ResponseHelper responseHelper;

    @Override
    public Response createObjective(String userName, ObjectiveInputDto objectiveInputDto) {
        ObjectiveDto objectiveDto = objectivesService.createObjective(userName, objectiveInputDto);
        return Response.created(URI.create(Paths.OBJECTIVES+"/" + objectiveDto.id())).entity(objectiveDto).build();
    }

    @Override
    public Response createAccomplishment(final UUID objectiveId, final AccomplishmentDto accomplishmentDto) {
        final AccomplishmentDto returnableDto = accomplishmentService.registerAccomplishment(objectiveId, accomplishmentDto);
        return Response.ok(returnableDto).build();
    }

    @Override
    public Response getCurrentAccomplishments(final UUID objectiveId) {
        List<AccomplishmentDto> accomplishmentsDto = accomplishmentService.getCurrentAccomplishments(objectiveId);
        return responseHelper.buildFromList(accomplishmentsDto).build();
    }
}
