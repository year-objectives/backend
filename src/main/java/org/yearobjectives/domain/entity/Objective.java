package org.yearobjectives.domain.entity;

import java.time.Instant;
import java.util.UUID;

public record Objective(UUID id, ObjectiveType type, Boolean reversible, Integer cellAmount, Instant createdAt, String user) {

}
