package com.example.testapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.model.Article
import kotlinx.android.synthetic.main.item_list.view.*


class MainAdapter(private var list: List<Article>, val listener:Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return   list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainAdapter.ViewHolder).bind(list.get(position))
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(position: Article){

            itemView.titleText.text=position.title
            itemView.descriptionText.text=position.description
            Glide.with(itemView).load(position.urlToImage).into(itemView.imgNews)
            itemView.tag = position
            itemView.setOnClickListener { v ->
                val position = v.tag as Article
                listener.setOnItemClick(position)

            }

        }
    }

    interface Listener{
        fun setOnItemClick(position: Article)

    }
}