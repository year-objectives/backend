package org.yearobjectives.domain.entity;

import java.util.List;
import java.util.UUID;

public record Objective(UUID id, Type type, Boolean reversible, List<Marker> objectiveMarkers, Integer cellAmount) {
            
    public record Marker(Boolean done, long concludedAt) {
        
    }

    public enum Type {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }
}
