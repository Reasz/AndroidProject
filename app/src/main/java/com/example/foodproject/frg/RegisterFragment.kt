package com.example.foodproject.frg

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.foodproject.R
import com.example.foodproject.data.User
import com.example.foodproject.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import java.net.PasswordAuthentication

class RegisterFragment : Fragment() {

    private lateinit var mUserViewModel:UserViewModel
    private lateinit var registerButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var emailAddressEditText: EditText
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

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        registerButton.setOnClickListener {

            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val username = usernameEditText.text.toString()
        val address = addressEditText.text.toString()
        val phoneNumber = phoneNumberEditText.text.toString()
        val email = emailAddressEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (inputCheck(username, password))
        {
            //Create user object
            val user = User(0, username, address, phoneNumber, email, password)
            // add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Registration success", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registerFragment_to_mainScreenFragment2)
        } else {
            Toast.makeText(requireContext(), "PLease fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(username:String, password:String):Boolean
    {
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password))
    }

    private fun initialise(view: View) {
        registerButton = view.findViewById(R.id.buttonRegisterRegister)
        usernameEditText = view.findViewById(R.id.editTextRegisterUsername)
        addressEditText = view.findViewById(R.id.editTextRegisterAddress)
        phoneNumberEditText = view.findViewById(R.id.editTextRegisterPhoneNumber)
        emailAddressEditText = view.findViewById(R.id.editTextRegisterEmail)
        passwordEditText = view.findViewById(R.id.editTextRegisterPassword)
    }

}