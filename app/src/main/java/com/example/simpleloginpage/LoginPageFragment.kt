package com.example.simpleloginpage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simpleloginpage.databinding.FragmentLoginPageBinding

class LoginPageFragment : Fragment() {

    private lateinit var viewModel: LoginPageViewModel
    private lateinit var _binding: FragmentLoginPageBinding
    private val binding get() = _binding

    private lateinit var adapter: PostListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginPageViewModel::class.java]

        binding.btnSendOTP.setOnClickListener {
            val mobile = binding.etMobile.text.toString()
            if (mobile.length == 10) {
                binding.edtotp.isEnabled = true
                Toast.makeText(view.context, "OTP Sent", Toast.LENGTH_SHORT).show()
            } else {
                binding.edtotp.isEnabled = false
                Toast.makeText(view.context, "Enter a valid mobile number", Toast.LENGTH_SHORT).show()
            }
        }

        binding.edtotp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.btnLogin.isEnabled = s?.length == 6
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.btnLogin.setOnClickListener {

            Toast.makeText(view.context, "Login Successful (Mock Validation)", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_loginPageFragment_to_homePageFragment)
        }


    }
}