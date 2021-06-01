package com.projeto.santanderdevweek.data.local

import com.projeto.santanderdevweek.data.Cartao
import com.projeto.santanderdevweek.data.Cliente
import com.projeto.santanderdevweek.data.Conta

class FakeData{

    // Dados do Cliente
    fun getLocalData() : Conta {
        val cliente = Cliente("Olá, Mayco Neves")
        val cartao = Cartao("5514")
        return Conta(
            "CC 01023-0",
            "Ag 00102030-4",
            "R$ 7.856,54",
            "R$ 17.856,54",
            cliente,
            cartao
        )
    }
}