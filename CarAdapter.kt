package com.project.hezy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.car_item.view.*

class CarAdapter(
    private val carList:ArrayList<CarItems>,
    private val onCarClickListener: OnCarClickListener
):RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    inner class CarViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent,false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem=carList[position]
        holder.itemView.apply {
            ivcar_item.setImageResource(currentItem.image)
            carName.text=currentItem.name
            amount.text=currentItem.amount
            seller.text=currentItem.seller
        }
        holder.itemView.setOnClickListener {
            onCarClickListener.onCarClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }


}