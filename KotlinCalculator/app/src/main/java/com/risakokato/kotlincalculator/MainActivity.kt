package com.risakokato.kotlincalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculate)

        button.setOnClickListener {
            var isValid = true

            val priceEditText = findViewById<EditText>(R.id.price)
            val priceText = priceEditText.text.toString()

            if(priceText.isEmpty()){

                priceEditText.error = "定価を入力してください"
                isValid = false

            }

            val discountEditText = findViewById<EditText>(R.id.discount)
            val discountText = discountEditText.text.toString()

            if(discountText.isEmpty()){

                discountEditText.error = "割引率を入力してください"
                isValid = false

            }

            if(isValid){

                val price = Integer.parseInt(priceText)
                val discount = Integer.parseInt(discountText)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("price",price)
                intent.putExtra("discount",discount)
                startActivity(intent)

            }
        }
    }
}
