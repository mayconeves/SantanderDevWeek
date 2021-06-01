package com.projeto.santanderdevweek.data

data class Conta (
    val contaNumero: String,
    val agencia: String,
    val saldo: String,
    val limite: String,
    val cliente: Cliente,
    val cartao: Cartao
)