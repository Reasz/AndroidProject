package com.example.foodproject.frg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodproject.*
import com.example.foodproject.repository.Repository
import kotlinx.android.synthetic.main.fragment_main_screen.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreenFragment : Fragment(), RestaurantAdapter.OnItemClickListener,
    AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: RestaurantViewModel
    private val restaurantAdapter by lazy { RestaurantAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_screen, container, false)

        initializeSpinner(view)

        setupRecyclerView(view)

        return view
    }

    override fun onItemClick(position: Int) {
        val clickedItem: RestaurantItem = restaurantAdapter.getDataAt(position)
        val action =
            MainScreenFragmentDirections.actionMainScreenFragment2ToDetailScreenFragment(clickedItem)
        findNavController().navigate(action)
    }

    private fun generateNewList(city: String) {
        val repository = Repository()
        val viewModelFactory = RestaurantViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantViewModel::class.java)

        viewModel.getCityPosts(city)
        viewModel.myCityPosts.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.restaurants?.let { restaurantAdapter.setData(it) }
            } else {
                Toast.makeText(activity, response.code(), Toast.LENGTH_SHORT).show()
                Log.d("Response ERROR", response.errorBody().toString())
            }
        })
    }

    private fun generateList() {
        val repository = Repository()
        val viewModelFactory = RestaurantViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantViewModel::class.java)

        viewModel.getAllPosts()
        viewModel.myAllPost.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.restaurants?.let { restaurantAdapter.setData(it) }
            } else {
                Toast.makeText(activity, response.code(), Toast.LENGTH_SHORT).show()
                Log.d("Response ERROR", response.errorBody().toString())
            }
        })
    }

    private fun setupRecyclerView(view: View) {
        view.mainRecyclerView.adapter = restaurantAdapter
        view.mainRecyclerView.layoutManager = LinearLayoutManager(activity)
        view.mainRecyclerView.setHasFixedSize(true)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val value: String = parent!!.getItemAtPosition(position).toString()
        generateNewList(value)
    }

    private fun initializeSpinner(view: View) {
        val spinner: Spinner = view.findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this
    }

}