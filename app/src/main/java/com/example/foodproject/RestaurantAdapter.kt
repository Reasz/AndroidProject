package com.example.foodproject

import android.os.Build.ID
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodproject.data.UserViewModel
import com.example.foodproject.util.Constants
import kotlinx.android.synthetic.main.restaurant_item.view.*


class RestaurantAdapter(//private var restaurantList: List<RestaurantItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private var restaurantList = emptyList<RestaurantItem>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)

        return RestaurantViewHolder(itemView)
    }

    // gets called again every time
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = restaurantList[position]

        // Glide image loading
        Glide.with(holder.view)
            .load(currentItem.image_url)
            .placeholder(R.mipmap.milky_way)
            .error(R.drawable.ic_broken_image)
            .into(holder.imageView)

        //holder.imageView.setImageResource(R.drawable.ic_list_bulleted)
        holder.textViewTitle.text = currentItem.name
        holder.textViewAddress.text = currentItem.address
        holder.textViewPrice.text = currentItem.price

        val favorite = holder.imageViewFavorite
        val unfavorite = holder.imageViewUnFavorite

        /*mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            user.forEach{
                if (it.id.toString() == ID) {
                    ///
                }
            }
        })*/

        unfavorite.setOnClickListener {
            if (unfavorite.visibility == View.VISIBLE) {
                favorite.visibility = View.VISIBLE
                unfavorite.visibility = View.INVISIBLE
            } else {
                favorite.visibility = View.INVISIBLE
                unfavorite.visibility = View.VISIBLE
            }
        }

        favorite.setOnClickListener {
            if (favorite.visibility == View.VISIBLE) {
                unfavorite.visibility = View.VISIBLE
                favorite.visibility = View.INVISIBLE
            } else {
                unfavorite.visibility = View.INVISIBLE
                favorite.visibility = View.VISIBLE
            }
        }

    }

    /*override fun getItemCount() = restaurantList.size
    }*/

    override fun getItemCount(): Int {
        return restaurantList.size
    }


    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.restaurantImageView // same as findViewById(...
        val textViewTitle: TextView = itemView.restaurantTitleTextView
        val textViewAddress: TextView = itemView.restaurantAddressTextView
        val textViewPrice: TextView = itemView.restaurantPriceTextView
        val imageViewFavorite: ImageView = itemView.favorite_icon_filled
        val imageViewUnFavorite: ImageView = itemView.favorite_icon_border
        val view = itemView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setData(newList: List<RestaurantItem>) {
        restaurantList = newList
        notifyDataSetChanged()
    }

    fun getDataAt(position: Int): RestaurantItem {
        return restaurantList[position]
    }
}