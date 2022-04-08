package com.example.cleanmvvmkoin.data.storage

import com.example.cleanmvvmkoin.data.storage.models.StringModel

interface StringStorage {

    fun set(params: StringModel): Boolean

    fun get(): StringModel
}