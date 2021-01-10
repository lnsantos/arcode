package com.lnsantos.arcore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.model_item.view.*

class ModelAdapter(private val models : List<Model>, private val onClicked: (model: Model) -> Unit) : RecyclerView.Adapter<ModelAdapter.BindView>(){

    private fun itemSelected(model: Model){
        models.forEach {
            it.selected = it.name == model.name
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.model_item, parent, false)
        return BindView(view)
    }

    override fun onBindViewHolder(holder: BindView, position: Int) {
        val item = models[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {view ->
            onClicked(item)
            itemSelected(item)
        }
    }

    override fun getItemCount(): Int = models.size

    inner class BindView(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(model: Model){
            view.name.text = model.name
            view.photo.setImageResource(model.photo)
            view.selected.visibility = if (model.selected) View.VISIBLE else View.INVISIBLE
        }

    }

}