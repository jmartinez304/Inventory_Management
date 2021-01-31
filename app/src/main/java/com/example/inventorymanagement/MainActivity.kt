package com.example.inventorymanagement

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

//        val products = listOf("Building", "Car", "Truck", "Ubuntu Laptop", "Macbook Pro", "Google Home")
        val products = listOf(
                Product("iPod", "Juan", 2006, 260.59),
                Product("Pixel", "John", 2009, 12.34),
                Product("Mac", "Nathan", 2020, 4999.99),
                Product("Monitor", "Hannah", 1999, 500.00),
                Product("Kotlin", "Mel", 1776, 0.0),
                Product("MacBook Pro", "Daniel Malone", 2020, 4399.99)
        )

        var totalCost = 0.0

        products.forEach {
            findViewById<TextView>(R.id.productsTextView).append("${it.name} - ${it.owner} - ${it.yearPurchased} - $ ${it.cost} \n\n")
            totalCost += it.cost
        }

        d("juan", "Total cost is $totalCost")

        findViewById<TextView>(R.id.totalCostTextView).text = "$ $totalCost"
    }
}