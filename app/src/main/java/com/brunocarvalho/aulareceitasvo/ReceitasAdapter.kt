package com.brunocarvalho.aulareceitasvo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ReceitasAdapter(
    val cliqueBotao: (Receita) -> Unit
): Adapter<ReceitasAdapter.ReceitaViewHolder>() {

    private var listaReceitas = mutableListOf<Receita>()

    fun configurarLista(lista: MutableList<Receita>){
        listaReceitas = lista
        notifyDataSetChanged()
    }

    inner class ReceitaViewHolder(itemView: View) : ViewHolder(itemView){

        val imagemAlimento: ImageView = itemView.findViewById(R.id.img_receita)
        val titulo: TextView = itemView.findViewById(R.id.text_titulo)
        val tempo: TextView = itemView.findViewById(R.id.text_tempo)
        val clItem: ConstraintLayout = itemView.findViewById(R.id.cl_item)


        fun onBind(receita: Receita){
            imagemAlimento.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, receita.resIdImagem)
            )
            titulo.text = receita.titulo
            tempo.text = receita.tempo

            //Evento de clique
            clItem.setOnClickListener{
                cliqueBotao(receita)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receitas , parent, false)

        return ReceitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        val receita = listaReceitas[position]
        holder.onBind(receita)
    }

    override fun getItemCount(): Int {
        return listaReceitas.size
    }
}