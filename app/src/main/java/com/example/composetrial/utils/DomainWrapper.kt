package com.example.composetrial.utils

import com.example.composetrial.mappers.IDomainMapper
import com.example.composetrial.repository.MoviesResponse

sealed class DomainWrapper<DomainModel> {
    data class Success<DomainModel>(val data: DomainModel) : DomainWrapper<DomainModel>()
}

fun <ResponseModel, DomainModel> MoviesResponse<ResponseModel>.mapToDomainWrapper(
    domainMapper: IDomainMapper<ResponseModel, DomainModel>
): DomainWrapper<DomainModel> {
    return when (this) {
        is MoviesResponse.Success -> DomainWrapper.Success(domainMapper.mapToDomainModel(this.data))
    }
}