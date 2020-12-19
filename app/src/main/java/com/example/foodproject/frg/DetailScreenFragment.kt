package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodproject.R
import kotlinx.android.synthetic.main.fragment_detail_screen.view.*
import kotlinx.android.synthetic.main.restaurant_item.view.*


/**
 * A [Fragment] subclass.
 * shows details about the selected restaurant
 */
class DetailScreenFragment : Fragment() {

    private val args by navArgs<DetailScreenFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_screen, container, false)

        initialise(view)

        // get reference to your image target
        val yourImageView = view.findViewById(R.id.restaurantDetailImageView) as ImageView

        // Glide image loading
        Glide.with(requireContext())
            .load(R.mipmap.milky_way)
            .into(yourImageView)

        return view
    }

    private fun initialise(view:View)
    {
        view.restaurantDetailTitleTextView.text = args.selectedRestaurant.name
        view.restaurantDetailPriceTextView.text = args.selectedRestaurant.price
        view.restaurantDetailAddressTextView.text = args.selectedRestaurant.address
    }

}