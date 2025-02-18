package org.yearobjectives.domain.assembler.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.yearobjectives.api.dto.ObjectiveDto;
import org.yearobjectives.domain.entity.Objective;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObjectiveApiAssembler {


    public List<ObjectiveDto> fromDomain(final List<Objective> objectives) {
        return Optional.ofNullable(objectives)
                .map(entities -> entities.stream().map(this::fromDomain).collect(Collectors.toList()))
                .orElse(null);
    }

    public ObjectiveDto fromDomain(final Objective objective) {
        return null;
    }

    public Objective fromApi(final ObjectiveDto objective) {
        return Optional.ofNullable(objective).map(obj -> new Objective(UUID.randomUUID(), Objective.Type.DAILY, false, Collections.emptyList(), 3)).orElse(null);
    }

}
