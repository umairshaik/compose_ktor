package com.example.composetrial.data.response

import kotlinx.serialization.Serializable

@Serializable
data class Movies(
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var budget: Int? = null,
    var genres: List<Genre>? = null,
    var homepage: String? = null,
    var id: Int? = null,
    var imdbId: String? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Float? = null,
    var posterPath: String? = null,
    var productionCompanies: List<ProductionCompany>? = null,
    var productionCountries: List<ProductionCountry>? = null,
    var releaseDate: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spokenLanguages: List<SpokenLanguage>? = null,
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Float? = null,
    var voteCount: Int? = null
)

@Serializable
data class Genre(
    var id: Int? = null,
    var name: String? = null
)

@Serializable
data class ProductionCompany(
    var id: Int? = null,
    var logoPath: String? = null,
    var name: String? = null,
    var originCountry: String? = null
)

@Serializable
data class ProductionCountry(
    var iso31661: String? = null,
    var name: String? = null
)

@Serializable
data class SpokenLanguage(
    var englishName: String? = null,
    var iso6391: String? = null,
    var name: String? = null
)