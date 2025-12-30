package com.objectives.management.infrastructure.database.model

import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.util.*
import java.util.Collections.emptyList

@Entity
@Table(name = "objectives")
@SQLRestriction("finished = false")
data class ObjectiveEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objectives_generator")
    @SequenceGenerator(name = "objectives_generator", sequenceName = "objectives_seq", allocationSize = 1)
    private val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    val user: UserEntity,

    val resourceId: UUID = UUID.randomUUID(),

    @Enumerated(value = EnumType.STRING)
    var type: ObjectiveType,

    var name: String,

    var reversible: Boolean,

    var description: String? = null,

    var targetAmount: Int,

    @ManyToMany
    @JoinTable(name = "objectives_tags", joinColumns = [JoinColumn(name = "objective_id")], inverseJoinColumns = [JoinColumn(name = "tag_id")])
    var tags: MutableList<TagEntity> = emptyList(),

    var finished: Boolean = false
) : AuditableEntity()
