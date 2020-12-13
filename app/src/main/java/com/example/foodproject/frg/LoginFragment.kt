package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.foodproject.R

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<Button>(R.id.buttonLoginLogin).setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainScreenFragment2)}
        view.findViewById<Button>(R.id.buttonLoginRegister).setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment2)}

        return view
    }
}