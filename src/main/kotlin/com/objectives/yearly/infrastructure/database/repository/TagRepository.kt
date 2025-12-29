package com.objectives.yearly.infrastructure.database.repository

import com.objectives.yearly.infrastructure.database.model.TagEntity
import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TagRepository: JpaRepository<TagEntity, Long> {

    fun findByUser(currentUser: UserEntity): List<TagEntity>
    fun findByResourceId(tagId: UUID): TagEntity?
    fun existsByNameAndUserResourceId(name: String,resourceId: UUID): Boolean

}