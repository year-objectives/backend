package com.objectives.yearly.domain.mapper.utils

interface ApiToModel<TApi, TModel> {

    fun toModel(api: TApi): TModel

    fun toModel(api: List<TApi>): List<TModel> {
        return api.map { a -> toModel(a) }
    }
}