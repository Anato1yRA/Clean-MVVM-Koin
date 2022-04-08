package com.example.cleanmvvmkoin.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanmvvmkoin.domain.models.GetStringModel
import com.example.cleanmvvmkoin.domain.models.SetStringModel
import com.example.cleanmvvmkoin.domain.usecase.GetStringUseCase
import com.example.cleanmvvmkoin.domain.usecase.SetStringUseCase

class MainViewModel(
    private val setStringUseCase: SetStringUseCase,
    private val getStringUseCase: GetStringUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    var resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.d("AAA", "VM init")
    }

    override fun onCleared() {
        Log.d("AAA", "VM cleared")
        super.onCleared()
    }

    fun set(firstText: String, lastText: String) {
        val params = SetStringModel(firstString = firstText, lastString = lastText)
        val result: Boolean = setStringUseCase.execute(params)
        resultLiveMutable.value = "Результат: $result"
    }

    fun get() {
        val getString: GetStringModel = getStringUseCase.execute()
        resultLiveMutable.value = "${getString.firstString} ${getString.lastString}"
    }
}