package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculatorapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstNumber = findViewById(R.id.etFirstNumber)
        etSecondNumber = findViewById(R.id.etSecondNumber)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener { calculate("add") }
        btnSubtract.setOnClickListener { calculate("subtract") }
        btnMultiply.setOnClickListener { calculate("multiply") }
        btnDivide.setOnClickListener { calculate("divide") }
    }

    private fun calculate(operation: String) {
        val firstNumber = etFirstNumber.text.toString().toDoubleOrNull()
        val secondNumber = etSecondNumber.text.toString().toDoubleOrNull()

        if (firstNumber == null || secondNumber == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "add" -> firstNumber + secondNumber
            "subtract" -> firstNumber - secondNumber
            "multiply" -> firstNumber * secondNumber
            "divide" -> {
                if (secondNumber != 0.0) {
                    firstNumber / secondNumber
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> 0.0
        }

        tvResult.text = result.toString()
    }
}
