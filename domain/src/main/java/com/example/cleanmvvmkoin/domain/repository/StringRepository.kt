package com.example.cleanmvvmkoin.domain.repository

import com.example.cleanmvvmkoin.domain.models.GetStringModel
import com.example.cleanmvvmkoin.domain.models.SetStringModel

interface StringRepository {

    fun setString(params: SetStringModel): Boolean

    fun getString(): GetStringModel
}