package com.example.cleanmvvmkoin.data.repository

import com.example.cleanmvvmkoin.data.storage.StringStorage
import com.example.cleanmvvmkoin.data.storage.models.StringModel
import com.example.cleanmvvmkoin.domain.models.GetStringModel
import com.example.cleanmvvmkoin.domain.models.SetStringModel
import com.example.cleanmvvmkoin.domain.repository.StringRepository

class StringRepositoryImpl(private val stringStorage: StringStorage) : StringRepository {

    override fun setString(params: SetStringModel): Boolean {
        val string = mapToStorage(params)

        return stringStorage.set(string)
    }

    override fun getString(): GetStringModel {
        val string = stringStorage.get()

        return mapToDomain(string)
    }

    private fun mapToStorage(params: SetStringModel): StringModel {
        return StringModel(firstString = params.firstString, lastString = params.lastString)
    }

    private fun mapToDomain(string: StringModel): GetStringModel {
        return GetStringModel(firstString = string.firstString, lastString = string.lastString)
    }
}