package org.yearobjectives.infrastructure.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "accomplishments")
public class AccomplishmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accomplishments_generator")
    @SequenceGenerator(name = "accomplishments_generator", sequenceName = "accomplishments_seq", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Column
    private UUID resourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ObjectiveEntity objective;

    @Column
    private Long doneAt;

    @Column
    private Boolean done;

    @Column
    private Long minPossibleStart;

    @Column
    private Long maxPossibleStart;

    public AccomplishmentEntity() {

    }

    public AccomplishmentEntity(final Long id, final String name, final UUID resourceId, final ObjectiveEntity objective, final Long doneAt, final Boolean done, final Long minPossibleStart, final Long maxPossibleStart) {
        this.id = id;
        this.name = name;
        this.resourceId = resourceId;
        this.objective = objective;
        this.doneAt = doneAt;
        this.done = done;
        this.minPossibleStart = minPossibleStart;
        this.maxPossibleStart = maxPossibleStart;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public ObjectiveEntity getObjective() {
        return objective;
    }

    public Long getDoneAt() {
        return doneAt;
    }

    public Boolean getDone() {
        return done;
    }

    public Long getMinPossibleStart() {
        return minPossibleStart;
    }

    public Long getMaxPossibleStart() {
        return maxPossibleStart;
    }
}
