package com.objectives.management.domain.mapper.utils

interface ApiToModel<TApi, TModel> {

    fun toModel(dto: TApi): TModel

    fun toModel(dtos: List<TApi>): List<TModel> {
        return dtos.map { dto -> toModel(dto) }
    }
}