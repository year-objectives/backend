package com.objectives.yearly.domain.mapper.utils

interface ModelToApi<TModel, TApi> {

    fun toApi(model: TModel): TApi

    fun toApi(model: List<TModel>): List<TApi> {
        return model.map { m -> toApi(m) }
    }
}