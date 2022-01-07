package com.example.composetrial.mappers

interface IDomainMapper<SourceModel, DomainModel> {
    fun mapToDomainModel(sourceModel: SourceModel): DomainModel
}



