package com.example.foodproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.restaurant_item.view.*


class RestaurantAdapter (//private var restaurantList: List<RestaurantItem>,
                         private val listener: OnItemClickListener
                         )
    : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private var restaurantList = emptyList<RestaurantItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)

        return  RestaurantViewHolder(itemView)
    }
    // mindig ujrahivodik
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = restaurantList[position]

        // Glide image loading
        Glide.with(holder.view)
            .load(currentItem.image_url)
            .placeholder(R.mipmap.milky_way)
            .into(holder.imageView)

        //holder.imageView.setImageResource(R.drawable.ic_list_bulleted)
        holder.textViewTitle.text =  currentItem.name
        holder.textViewAddress.text = currentItem.address
        holder.textViewPrice.text = currentItem.price
    }

    /*override fun getItemCount() = restaurantList.size
    }*/

    override fun getItemCount(): Int {
        return restaurantList.size
    }


    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        val imageView: ImageView = itemView.restaurantImageView // same as findViewById(...
        val textViewTitle: TextView = itemView.restaurantTitleTextView
        val textViewAddress: TextView = itemView.restaurantAddressTextView
        val textViewPrice: TextView = itemView.restaurantPriceTextView
        val view = itemView
        /*val imageView: ImageView = itemView.findViewById(R.id.restaurantImageView)
        val textView1: TextView = itemView.findViewById(R.id.restaurantTitleTextView)
        val textView2: TextView = itemView.findViewById(R.id.restaurantAddressTextView)*/

        init
        {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener
    {
        fun onItemClick(position: Int)
    }

    fun setData(newList: List<RestaurantItem>) {
        restaurantList = newList
        notifyDataSetChanged()
    }

    fun getDataAt(position: Int):RestaurantItem{
        return  restaurantList[position]
    }
}