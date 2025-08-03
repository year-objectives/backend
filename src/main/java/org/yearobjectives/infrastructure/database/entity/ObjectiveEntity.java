package org.yearobjectives.infrastructure.database.entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "objectives")
public class ObjectiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objectives_generator")
    @SequenceGenerator(name = "objectives_generator", sequenceName = "objectives_seq", allocationSize = 1)
    private Long id;

    @Column
    private UUID resourceId;

    @Column
    private String type;

    @Column
    private Boolean reversible;

    @Column
    private Integer targetAmount;

    @Column
    private Long createdAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private UserEntity user;

    @OneToMany(mappedBy = "objective", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<AccomplishmentEntity> accomplishments;

    public ObjectiveEntity() {
    }

    public ObjectiveEntity(final UUID resourceId, final String type, final Boolean reversible, final Integer targetAmount, final Long createdAt, final UserEntity user) {
        this.resourceId = resourceId;
        this.type = type;
        this.reversible = reversible;
        this.targetAmount = targetAmount;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public String getType() {
        return type;
    }

    public Boolean getReversible() {
        return reversible;
    }

    public Integer getTargetAmount() {
        return targetAmount;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public List<AccomplishmentEntity> getAccomplishments() {
        return accomplishments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceId, type, reversible, targetAmount, createdAt, user, accomplishments);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjectiveEntity other = (ObjectiveEntity) obj;
        return Objects.equals(id, other.id) && Objects.equals(resourceId, other.resourceId)
                && Objects.equals(type, other.type) && Objects.equals(reversible, other.reversible)
                && Objects.equals(targetAmount, other.targetAmount) && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(user, other.user) && Objects.equals(accomplishments, other.accomplishments);
    }

    
}

