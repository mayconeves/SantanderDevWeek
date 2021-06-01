package com.projeto.santanderdevweek.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto.santanderdevweek.data.Conta
import com.projeto.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    // Dado a ser observado no futuro
    // Dados que podem ser alterados
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta>{
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }
}