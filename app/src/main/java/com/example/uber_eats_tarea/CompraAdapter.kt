package com.example.uber_eats_tarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompraAdapter (private val ordenes: List<Orden>) : RecyclerView.Adapter<CompraAdapter.CompraViewHolder>(){
    inner class CompraViewHolder(renglon: View): RecyclerView.ViewHolder(renglon){
        var compra_id = renglon.findViewById<TextView>(R.id.compra_id)
        var subtotal = renglon.findViewById<TextView>(R.id.subtotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompraViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglon_layout = inflater.inflate(R.layout.renglon_layout, parent, false)
        return CompraViewHolder(renglon_layout);
    }

    override fun onBindViewHolder(holder: CompraViewHolder, position: Int) {
        val dato = ordenes[position]
        holder.compra_id.text = dato.compra_id.toString()
        holder.subtotal.text = dato.subtotal.toString()

    }

    override fun getItemCount(): Int {
        return ordenes.size
    }
}