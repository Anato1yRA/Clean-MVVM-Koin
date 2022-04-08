package com.example.cleanmvvmkoin.domain.usecase

import com.example.cleanmvvmkoin.domain.models.GetStringModel
import com.example.cleanmvvmkoin.domain.repository.StringRepository

class GetStringUseCase(private val stringRepository: StringRepository) {

    fun execute(): GetStringModel {
        return stringRepository.getString()
    }
}