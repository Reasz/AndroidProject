package com.example.foodproject.frg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.foodproject.R
import java.net.PasswordAuthentication

class RegisterFragment : Fragment() {

    private lateinit var registerButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        initialise(view)

        registerButton.setOnClickListener {

            val usernameText = usernameEditText.text.toString()
            val passwordText = passwordEditText.text.toString()

            when {
                usernameText.isEmpty() -> {
                    usernameEditText.error = "Username required"
                }
                usernameText.length < 3 -> {
                    usernameEditText.error = "Username must be at least 3 letters"
                }
                passwordText.isEmpty() -> {
                    passwordEditText.error = "Password required"
                }
                passwordText.length < 4 -> {
                    passwordEditText.error = "Password must be at least 4 letters"
                }
                else -> {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_registerFragment_to_mainScreenFragment2)
                }
            }
        }

        return view
    }

    private fun initialise(view: View) {
        registerButton = view.findViewById(R.id.buttonRegisterRegister)
        usernameEditText = view.findViewById(R.id.editTextRegisterUsername)
        passwordEditText = view.findViewById(R.id.editTextRegisterPassword)
    }

}