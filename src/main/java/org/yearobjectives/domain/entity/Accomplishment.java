package org.yearobjectives.domain.entity;

import java.time.Instant;

public record Accomplishment(Boolean done, Instant concludedAt) {

}
