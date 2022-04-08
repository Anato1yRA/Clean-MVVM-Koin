package com.example.cleanmvvmkoin.data.storage.sharedprefs

import android.content.Context
import com.example.cleanmvvmkoin.data.storage.StringStorage
import com.example.cleanmvvmkoin.data.storage.models.StringModel

private const val SHARED_PREFS_STRING = "shared_prefs_string"
private const val KEY_STRING_FIRST = "firstString"
private const val KEY_STRING_LAST = "lastString"
private const val DEFAULT_STRING_FIRST = "Default first String"
private const val DEFAULT_STRING_LAST = "Default last String"

class StringStorageImpl(context: Context) : StringStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_STRING, Context.MODE_PRIVATE)

    override fun set(stringModel: StringModel): Boolean {
        sharedPreferences.edit().putString(KEY_STRING_FIRST, stringModel.firstString).apply()
        sharedPreferences.edit().putString(KEY_STRING_LAST, stringModel.lastString).apply()
        return true
    }

    override fun get(): StringModel {
        val firstString =
            sharedPreferences.getString(KEY_STRING_FIRST, DEFAULT_STRING_FIRST)
                ?: DEFAULT_STRING_FIRST
        val lastString =
            sharedPreferences.getString(KEY_STRING_LAST, DEFAULT_STRING_LAST) ?: DEFAULT_STRING_LAST

        return StringModel(firstString = firstString, lastString = lastString)
    }
}