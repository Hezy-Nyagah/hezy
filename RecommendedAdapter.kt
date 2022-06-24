package com.project.hezy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recommended_item.view.*

class RecommendedAdapter(
    private val photoRecommended:ArrayList<RecommendedItem>
):RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder>() {

    class RecommendedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recommended_item,parent,false)
        return RecommendedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val currentItem=photoRecommended[position]
        holder.itemView.apply {
            image.setImageResource(currentItem.image)
            title.text=currentItem.title
           description.text=currentItem.Description

        }
    }

    override fun getItemCount(): Int {
        return photoRecommended.size
    }
}