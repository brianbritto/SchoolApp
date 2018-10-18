package com.softinca.education.schoolapp.estudiante.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.softinca.education.schoolapp.R
import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import com.softinca.education.schoolapp.helper.CircleTransform
import com.softinca.education.schoolapp.helper.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_estudiante.view.*

class EstudianteAdapter(val context : Context, val listener: (EstudianteResponse) -> Unit) : RecyclerView.Adapter<EstudianteAdapter.ViewHolder>() {

    var items: MutableList<EstudianteResponse> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, position: Int): ViewHolder {
        val view = p0.inflate(R.layout.item_estudiante)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items.isNotEmpty()) return items.size
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: EstudianteResponse, listener: (EstudianteResponse) -> Unit) {
            itemView.nombres_estudiante_textview.text = item.nombres + " " + item.apellidos
            itemView.grado_estudiante_textview.text = item.grado
            itemView.edad_estudiante_textview.text = item.edad.toString()
            Picasso.with(itemView.context)
                    .load(item.fotoUrl)
                    .placeholder(R.drawable.nouser)
                    .error(R.drawable.nouser)
                    .transform(CircleTransform())
                    .into(itemView.foto_estudiante_imageview)
        }
    }

    fun setList(list: ArrayList<EstudianteResponse>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}