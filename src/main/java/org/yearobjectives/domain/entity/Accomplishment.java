package org.yearobjectives.domain.entity;

import java.time.Instant;
import java.util.UUID;

public record Accomplishment(UUID resourceId, Boolean done, Instant concludedAt) {

}
