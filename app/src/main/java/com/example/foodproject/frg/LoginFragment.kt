package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.foodproject.R
import com.example.foodproject.data.UserViewModel
import com.example.foodproject.util.Constants.Companion.userID

class LoginFragment : Fragment() {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        initialise(view)

        loginButton.setOnClickListener {
            val usernameText = usernameEditText.text.toString()
            val passwordText = passwordEditText.text.toString()

            when {
                usernameText.isEmpty() -> {
                    usernameEditText.error = "Username required"
                }
                passwordText.isEmpty() -> {
                    passwordEditText.error = "Password required"
                }
                else -> {
                    var found = false
                    mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
                    mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
                        user.forEach{
                            if (it.userName == usernameText && it.password == passwordText) {
                                userID = it.id
                                found = true
                                Navigation.findNavController(view)
                                    .navigate(R.id.action_loginFragment_to_mainScreenFragment2)
                            }
                        }
                    })
                    if (!found) {
                        Toast.makeText(requireContext(), "Wrong username or password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        registerButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_registerFragment2)
        }

        return view
    }

    private fun initialise(view: View) {
        loginButton = view.findViewById(R.id.buttonLoginLogin)
        registerButton = view.findViewById(R.id.buttonLoginRegister)
        usernameEditText = view.findViewById(R.id.editTextLoginUsername)
        passwordEditText = view.findViewById(R.id.editTextLoginPassword)
    }
}