package com.example.inventorymanagement

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_product)

        findViewById<Button>(R.id.addProductSubmitButton).setOnClickListener {
            val database = getSharedPreferences("database", Context.MODE_PRIVATE)
            database.edit().apply {
                putString("savedProductName", findViewById<EditText>(R.id.editTextProductName).text.toString())
            }.apply()
        }
    }
}