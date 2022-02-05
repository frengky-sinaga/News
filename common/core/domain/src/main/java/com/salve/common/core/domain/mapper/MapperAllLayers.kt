package com.salve.common.core.domain.mapper

interface MapperAllLayers<Domain, Entity, Dto> {
    fun domainToEntity(): Mapper<Domain, Entity>
    fun entityToDomain(): Mapper<Entity, Domain>
    fun dtoToEntity(): Mapper<Dto, Entity>
}