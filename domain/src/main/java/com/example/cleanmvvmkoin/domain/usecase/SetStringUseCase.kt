package com.example.cleanmvvmkoin.domain.usecase

import com.example.cleanmvvmkoin.domain.models.SetStringModel
import com.example.cleanmvvmkoin.domain.repository.StringRepository

class SetStringUseCase(private val stringRepository: StringRepository) {

    fun execute(params: SetStringModel): Boolean {
        val oldString = stringRepository.getString()

        if (params.firstString.isEmpty() || params.lastString.isEmpty()) {
            return false
        }
        if (oldString.firstString == params.firstString && oldString.lastString == params.lastString) {
            return false
        }
        return stringRepository.setString(params = params)
    }
}