package com.example.foodproject

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.restaurant_item.view.*


class RestaurantAdapter (private val restaurantList: List<RestaurantItem>)
    : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)

        return  RestaurantViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = restaurantList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textViewTitle.text = currentItem.title
        holder.textViewAddress.text = currentItem.address
        holder.textViewPrice.text = currentItem.price
    }

    /*override fun getItemCount() = restaurantList.size
    }*/

    override fun getItemCount(): Int {
        return restaurantList.size
    }


    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.restaurantImageView // same as findViewById(...
        val textViewTitle: TextView = itemView.restaurantTitleTextView
        val textViewAddress: TextView = itemView.restaurantAddressTextView
        val textViewPrice: TextView = itemView.restaurantPriceTextView
        /*val imageView: ImageView = itemView.findViewById(R.id.restaurantImageView)
        val textView1: TextView = itemView.findViewById(R.id.restaurantTitleTextView)
        val textView2: TextView = itemView.findViewById(R.id.restaurantAddressTextView)*/
    }
}