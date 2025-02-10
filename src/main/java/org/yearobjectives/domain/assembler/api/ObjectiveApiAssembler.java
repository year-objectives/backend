package org.yearobjectives.domain.assembler.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.yearobjectives.api.dto.ObjectiveDTO;
import org.yearobjectives.domain.entity.Objective;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObjectiveApiAssembler {


    public List<ObjectiveDTO> fromDomain(final List<Objective> objectives) {
        return Optional.ofNullable(objectives)
                .map(entities -> entities.stream().map(this::fromDomain).collect(Collectors.toList()))
                .orElse(null);
    }

    public ObjectiveDTO fromDomain(final Objective objective) {
        return Optional.ofNullable(objective).map(obj -> new ObjectiveDTO(obj.id(), obj.name(), obj.timestamp().getEpochSecond())).orElse(null);
    }

}
