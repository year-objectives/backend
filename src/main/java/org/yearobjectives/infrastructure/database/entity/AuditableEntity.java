package org.yearobjectives.infrastructure.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public abstract class AuditableEntity {

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Instant updatedDate;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;


    protected AuditableEntity() {
    }

    protected AuditableEntity(final Instant updatedDate, final Instant createdDate) {
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final AuditableEntity that)) {
            return false;
        }
        return Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updatedDate, createdDate);
    }
}
