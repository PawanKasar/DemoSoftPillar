package com.example.demopillar.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.demopillar.databinding.FragmentMainBinding
import com.example.demopillar.viewmodel.LoginViewModel
import com.example.kotlindemowithretrofit.presentor.controller.Utilities.CallingImportantMethod


class MainFragment : Fragment() {

    private var loginViewModel: LoginViewModel? = null
    private lateinit var binding : FragmentMainBinding
    lateinit var mContext: Context
    private lateinit var hashMap:HashMap<String, String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        //DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val view = binding.root
        loginViewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hashMap = HashMap<String, String>()


        binding.btnLogin.setOnClickListener {
            requestServerForLogin(binding.edtUserId.text.toString(),binding.edtPassword.text.toString())
        }
    }

    private fun requestServerForLogin(email: String, password: String){
        hashMap["email"] = email
        hashMap["password"] = password
        Log.e("MainFragment", "Map value $hashMap")
        context?.let { it1 -> loginViewModel?.loadTestData(it1, hashMap) }  // context was giving null pointer exception so handled it by let it kotlin extention
    }

}