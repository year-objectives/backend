package com.objectives.yearly.infrastructure.database.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.Instant
import java.util.*

@Entity
@Table(name = "objectives")
data class ObjectiveEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objectives_generator")
    @SequenceGenerator(name = "objectives_generator", sequenceName = "objectives_seq", allocationSize = 1)
    private val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    val user: UserEntity,
    @Enumerated(value = EnumType.STRING)
    var type: ObjectiveType,
    var name: String,
    val resourceId: UUID = UUID.randomUUID(),
    var reversible: Boolean,
    var description: String? = null,
    var targetAmount: Int) : AuditableEntity()
