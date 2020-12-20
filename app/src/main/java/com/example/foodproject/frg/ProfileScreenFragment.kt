package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.foodproject.R
import com.example.foodproject.RestaurantAdapter
import com.example.foodproject.RestaurantItem
import kotlinx.android.synthetic.main.fragment_main_screen.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileScreenFragment : Fragment(), RestaurantAdapter.OnItemClickListener {

    private val exampleList = generateDummyList(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_screen, container, false)

        // get reference to your image target
        val yourImageView = view.findViewById(R.id.ProfileImageImageView) as ImageView

        // Glide image loading
        Glide.with(requireContext())
            .load(R.mipmap.stars)
            .into(yourImageView)

        view.mainRecyclerView.adapter = RestaurantAdapter(this)
        view.mainRecyclerView.layoutManager = LinearLayoutManager(activity)
        view.mainRecyclerView.setHasFixedSize(true)

        return view
    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT)
        val clickedItem: RestaurantItem = exampleList[position]
        val action =
            ProfileScreenFragmentDirections.actionProfileScreenFragmentToDetailScreenFragment(
                clickedItem
            )
        findNavController().navigate(action)
    }

    //TODO: EZT KISZEDNI
    private fun generateDummyList(size: Int): List<RestaurantItem> {
        val list = ArrayList<RestaurantItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_home
                1 -> R.drawable.ic_list_bulleted
                else -> R.drawable.ic_profile
            }
            val item = RestaurantItem(drawable, "Title $i", "Address $i", "City: $i", "State: $i", "Area: $i",
                "Postal code $i", "Country: $i", 0,0,0, "Price $i",
                "Reserve url $i","mobile_reserve_url $i", "Image url $i" )
            list += item
        }
        return list
    }

}