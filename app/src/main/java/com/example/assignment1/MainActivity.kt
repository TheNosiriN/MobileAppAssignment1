package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mortgageAmount = findViewById<EditText>(R.id.mortgageAmount)
        val tenure = findViewById<EditText>(R.id.tenure)
        val interestRate = findViewById<EditText>(R.id.interestRate)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val result = findViewById<TextView>(R.id.result)

        calculateBtn.setOnClickListener {
            try {
                val principal = mortgageAmount.text.toString().toDouble()
                val rate = interestRate.text.toString().toDouble() / 12 / 100
                val months = tenure.text.toString().toInt()

                // EMI formula
                val emi = (principal * rate * Math.pow(1 + rate.toDouble(), months.toDouble())) /
                        (Math.pow(1 + rate.toDouble(), months.toDouble()) - 1)

                result.text = "Your Monthly EMI is: %.2f".format(emi)
            } catch (e: NumberFormatException) {
                result.text = "Invalid input! Please enter valid numbers."
            }
        }
    }
}