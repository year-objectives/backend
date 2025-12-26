package com.objectives.yearly.infrastructure.database.model

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "accomplishments")
data class AccomplishmentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accomplishments_generator")
    @SequenceGenerator(name = "accomplishments_generator", sequenceName = "accomplishments_seq", allocationSize = 1)
    private val id: Long? = null,
    val resourceId: UUID = UUID.randomUUID(),
    var doneAt: Long? = null,
    var done: Boolean,
    val minPossibleStart: Long,
    val maxPossibleStart: Long,
    var description: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objective_id", nullable = false)
    val objective: ObjectiveEntity) : AuditableEntity()