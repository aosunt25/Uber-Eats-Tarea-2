package com.example.uber_eats_tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_compras.*
import java.time.LocalDateTime
import kotlin.random.Random

class ComprasActivity : AppCompatActivity() {
    private lateinit var compraAdapter : CompraAdapter
    private lateinit var ordenes : ArrayList<Orden>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compras)
        initRecycler()
    }

    fun initRecycler(){
        ordenes = ArrayList<Orden>()
        compraAdapter = CompraAdapter(ordenes)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = compraAdapter
        for( i in 0..30){
            val subtotal = String.format( "%.2f" , 1 + Random.nextDouble() ).toFloat()
            val orden = Orden(i,  subtotal)
            ordenes.add(orden)
        }
    }
}