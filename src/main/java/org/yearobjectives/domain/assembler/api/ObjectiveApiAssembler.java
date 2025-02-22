package org.yearobjectives.domain.assembler.api;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.api.dto.ObjectiveInputDto;
import org.yearobjectives.api.dto.ObjectiveMarkerDto;
import org.yearobjectives.api.dto.ObjectiveTypeDto;
import org.yearobjectives.api.filter.request.UserInformation;
import org.yearobjectives.domain.entity.Objective;
import org.yearobjectives.domain.entity.Objective.Marker;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ObjectiveApiAssembler {

    @Inject
    UserInformation userInformation;

    public ObjectiveDto fromDomain(final Objective objective) {
        return Optional.ofNullable(objective)
        .map(obj -> new ObjectiveDto(objective.id(), ObjectiveTypeDto.valueOf(objective.type().name()), objective.reversible(), this.fromDomain(objective.objectiveMarkers()))).orElse(null);
    }

    public Objective fromApi(final ObjectiveInputDto objective) {
        return Optional.ofNullable(objective)
            .map(obj -> new Objective(UUID.randomUUID(), Objective.Type.valueOf(objective.type().name()), objective.reversible(), Collections.emptyList(), objective.cellAmount(), Instant.now(), userInformation.getCurrentUser().name())).orElse(null);
    }

    private List<ObjectiveMarkerDto> fromDomain(final List<Marker> markers) {
        return Optional.ofNullable(markers)
                .map(entities -> entities.stream().map(this::fromDomain).collect(Collectors.toList()))
                .orElse(null);
    }

    private ObjectiveMarkerDto fromDomain(final Marker marker) {
        return Optional.ofNullable(marker)
        .map(mkr -> new ObjectiveMarkerDto(mkr.done(), mkr.concludedAt()))
        .orElse(null);
    }
}
