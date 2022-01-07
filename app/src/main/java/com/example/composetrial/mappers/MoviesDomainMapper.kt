package com.example.composetrial.mappers

import com.example.composetrial.data.response.Movies

class MoviesDomainMapper : IDomainMapper<Movies, Movies> {
    override fun mapToDomainModel(sourceModel: Movies): Movies {
        return sourceModel
    }
}