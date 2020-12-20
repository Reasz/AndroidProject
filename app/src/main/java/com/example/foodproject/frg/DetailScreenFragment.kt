package com.example.foodproject.frg

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodproject.R
import kotlinx.android.synthetic.main.fragment_detail_screen.view.*


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

        view.restaurantDetailPhoneTextView.setOnClickListener{
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${view.restaurantDetailPhoneTextView.text}")
            startActivity(callIntent)
        }

        val ln = args.selectedRestaurant.lng
        val lat = args.selectedRestaurant.lat

        view.restaurantDetailAddressTextView.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/maps/search/?api=1&query=$lat,$ln")
            startActivity(intent)
        }

        view.restaurantDetailReserveButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(args.selectedRestaurant.mobile_reserve_url)
            startActivity(intent)
        }

        return view
    }

    private fun initialise(view:View)
    {
        view.restaurantDetailTitleTextView.text = args.selectedRestaurant.name
        view.restaurantDetailPriceTextView.text = args.selectedRestaurant.price
        view.restaurantDetailAddressTextView.text = args.selectedRestaurant.address
        view.restaurantDetailCityTextView.text = args.selectedRestaurant.city
        view.restaurantDetailPhoneTextView.text = args.selectedRestaurant.phone.toString()
    }

}