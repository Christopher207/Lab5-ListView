package com.example.lab5_listview

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arrSO = arrayOf(
        "Android","iPhone","Windows Phone","Backberry","Firefox OS","Amazon World","Nokia"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lsvSistemasOperativos: ListView = findViewById<View>(R.id.lsvSO) as ListView
        val adaptador: Any? =
            ArrayAdapter<Any?>(this,android.R.layout.simple_list_item_1,arrSO)
        lsvSistemasOperativos.adapter = adaptador as ListAdapter?

        lsvSistemasOperativos.setOnItemClickListener{ parent, view,position,id->
            Toast.makeText(
                applicationContext,
                "Posición: $position",
                Toast.LENGTH_SHORT
            ).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}