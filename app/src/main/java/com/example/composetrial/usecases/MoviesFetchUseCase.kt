package com.example.composetrial.usecases

import com.example.composetrial.data.response.Movies
import com.example.composetrial.mappers.IDomainMapper
import com.example.composetrial.repository.IMoviesRepository
import com.example.composetrial.utils.DomainWrapper
import com.example.composetrial.utils.mapToDomainWrapper
import kotlinx.coroutines.flow.single

class MoviesFetchUseCase(
    private val moviesRepository: IMoviesRepository,
    private val moviesListIDomainMapper: IDomainMapper<Movies, Movies>
) {
    suspend fun getMovies(): DomainWrapper<Movies> {
        return moviesRepository.getMovies().single().mapToDomainWrapper(moviesListIDomainMapper)
    }
}