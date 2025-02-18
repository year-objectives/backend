package org.yearobjectives.api.resources;

import org.yearobjectives.AppUtils.Misc;
import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.resources.utils.ResponseHelper;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.yearobjectives.domain.service.ObjectiveService;

public class ObjectiveResourcesImpl implements ObjectiveResources {

    @Inject
    private ObjectiveService objectivesService;

    @Inject
    private ResponseHelper responseHelper;


    @Override
    @Timed(description = "Get all objectives", absolute = true,
    name = Misc.METRICS_PREFIX + "getMicroservicesScenarios")
    public Response getAll() {
        final List<ObjectiveDto> objectives = objectivesService.getAllObjectives();
        return responseHelper.buildFromList(objectives).build();
    }
}
