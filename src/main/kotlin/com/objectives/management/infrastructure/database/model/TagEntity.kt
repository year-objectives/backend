package com.objectives.management.infrastructure.database.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tags")
data class TagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_generator")
    @SequenceGenerator(name = "tags_generator", sequenceName = "tags_seq", allocationSize = 1)
    private val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    val user: UserEntity,

    val name: String,

    val resourceId: UUID = UUID.randomUUID()
) : AuditableEntity()
