package org.yearobjectives.domain.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Objective(UUID id, MarkerType type, Boolean reversible, List<Marker> objectiveMarkers, Integer cellAmount, Instant startAt, String user) {
            
    public record Marker(Boolean done, long concludedAt, UUID parentId, Instant startsAt, Instant endsAt) {
    }
}
