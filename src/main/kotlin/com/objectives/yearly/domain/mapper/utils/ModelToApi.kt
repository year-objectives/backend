package com.objectives.yearly.domain.mapper.utils

interface ModelToApi<TModel, TApi> {

    fun toView(model: TModel): TApi

    fun toView(model: List<TModel>): List<TApi> {
        return model.map { m -> toView(m) }
    }
}