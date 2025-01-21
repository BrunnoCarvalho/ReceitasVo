package com.brunocarvalho.aulareceitasvo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    val lista = mutableListOf(
        Receita("Escondidinho de camarão", "25 min", R.drawable.carne1
            ,listOf("1 KG de camarão", "Manteiga", "Alho", "Cebola")
            ),
        Receita("Panqueca de carne moída", "15 min", R.drawable.carne2
            ,listOf("1 KG de carne", "Manteiga", "Alho")
            ),
        Receita("Rocambole de carne moída", "30 min", R.drawable.carne3
            ,listOf("Carne a vontade", "Manteiga", "Alho", "Cebola")
        ),
        Receita("Escondidinho de carne seca", "45 min", R.drawable.carne4
            ,listOf("1 KG de carne seca", "Manteiga", "Alho", "Cebola", "Farinha")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvReceitas = findViewById(R.id.rv_receitas)

        //Adapter
        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter

        receitasAdapter.configurarLista(lista)

        //Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)
    }
}