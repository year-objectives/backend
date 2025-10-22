package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.api.dto.views.UserView
import com.objectives.yearly.domain.mapper.utils.ApiToModel
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapper(): ApiToModel<UserRegisterForm, UserEntity>, ModelToApi<UserEntity, UserView> {

    override fun toModel(api: UserRegisterForm): UserEntity {
        return UserEntity(name = api.name, userName = api.userName, email = api.email, password = api.password)
    }

    override fun toView(model: UserEntity): UserView {
        return UserView(model.resourceId, model.name, model.userName, model.email)
    }
}