package org.yearobjectives.domain.entity;

import java.time.Instant;

public record Objective(String id, Instant timestamp, String name) {
}
