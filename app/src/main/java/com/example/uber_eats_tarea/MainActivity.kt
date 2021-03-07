package com.example.uber_eats_tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var subtotal = 0.0f
    var orderFee = 0.0f
    var serviceFee = 0.0f
    var deliverFee = 0.0f
    var propina = 1.0f

    var total = 0.0f
    var compra_id = 0
    var listaCompra = mutableListOf<Orden>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        subtotalEditTextNumberDecimal.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!TextUtils.isEmpty(subtotalEditTextNumberDecimal.text.toString())){
                    subTotlaTextView.text = p0.toString()
                    subtotal = p0.toString().toFloat()

                    orderFee = subtotal * 0.02f
                    serviceFee = subtotal * 0.05f
                    deliverFee = subtotal * 0.1f

                    orderFeeTextView.text = orderFee.toString()
                    serviceFeeTextView.text = serviceFee.toString()
                    valorPropinaTextView3.text = deliverFee.toString()

                    total = (subtotal + orderFee + serviceFee + deliverFee) * propina

                    placeOrderButton.text = total.toString()
                }

            }

        })

        diezDescButton.setOnClickListener{
            propina = 1.1f
            total = (subtotal + orderFee + serviceFee + deliverFee) * propina
            placeOrderButton.text = total.toString()
        }

        quinceDescButton.setOnClickListener {
            propina = 1.15f
            total = (subtotal + orderFee + serviceFee + deliverFee) * propina
            placeOrderButton.text = total.toString()
        }

        veinteDescButton.setOnClickListener {
            propina = 1.2f
            total = (subtotal + orderFee + serviceFee + deliverFee) * propina
            placeOrderButton.text = total.toString()
        }

        veintiCincoDescButton.setOnClickListener {
            propina = 1.25f
            total = (subtotal + orderFee + serviceFee + deliverFee) * propina
            placeOrderButton.text = total.toString()
        }

        ceroDescButton.setOnClickListener {
            propina = 1.0f
            total = (subtotal + orderFee + serviceFee + deliverFee) * propina
            placeOrderButton.text = total.toString()
        }


    }
    fun guardarOrden(view: View){
        compra_id +=1
        subtotal =  placeOrderButton.text.toString().toFloat()
        var orden = Orden(compra_id, subtotal)
        listaCompra.add(orden)
        subtotalEditTextNumberDecimal.text.clear()
        subTotlaTextView.text = "0"
        placeOrderButton.text = "0"
        orderFeeTextView.text = "0"
        serviceFeeTextView.text = "0"
        valorPropinaTextView3.text = "0"
         subtotal = 0.0f
         orderFee = 0.0f
         serviceFee = 0.0f
         deliverFee = 0.0f
         propina = 1.0f
         total = 0.0f

        Log.i("com.example.uber_eats_tarea.lista", listaCompra.toString())
    }
}