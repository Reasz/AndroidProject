package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.foodproject.MainActivity
import com.example.foodproject.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashScreenFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        launch {
            delay(3000)
            withContext(Dispatchers.Main) {
                Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }
        }
    }
}