package com.projeto.santanderdevweek.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.projeto.santanderdevweek.R
import com.projeto.santanderdevweek.data.Conta
import com.projeto.santanderdevweek.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    // Carregar posteriomente
    private lateinit var mainViewModel: MainViewModel

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        // Criar o escopo desta activity recuperando a viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Acessar os dados observando suas mudanças
        buscarContaCliente()

        // Force Crash
        //throw RuntimeException("Teste Crash")

    }

    private  fun buscarContaCliente(){
        // Acessar os dados observando suas mudanças
        mainViewModel.buscarContaCliente().observe(this, Observer {
            // Resultado
                result ->
            // Popular dados na view
            bindOnView(result)
        })
    }

    private fun bindOnView(conta : Conta){
        // Popular dados na view
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_conta_corrente).text = conta.contaNumero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_saldo_limite_valor).text = conta.limite
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Toast.makeText(this, "Menu 1 selecionado", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}