package com.example.vpb.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val entityList: ArrayList<Entity>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bindItems(entityList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return entityList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(entity: Entity){
            val textViewName = itemView.findViewById(R.id.textViewName) as TextView
            val textViewLogin  = itemView.findViewById(R.id.textViewLogin) as TextView
            val textViewPass  = itemView.findViewById(R.id.textViewPass) as TextView
            textViewName.text = entity.name
            textViewLogin.text = entity.login
            textViewPass.text = entity.pass
        }
    }
}