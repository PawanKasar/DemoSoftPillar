package com.example.demopillar.viewmodel

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demopillar.model.LoginModel
import com.example.demopillar.network.ApiCallbacks
import com.example.demopillar.network.ApiServices
import com.example.kotlindemowithretrofit.presentor.controller.Utilities.CallingImportantMethod

class LoginViewModel : ViewModel() {

    private var showLoader: MutableLiveData<Boolean> = MutableLiveData()

    private var userMutableLiveData: MutableLiveData<LoginModel>? = null

    fun getTestData(): MutableLiveData<LoginModel>? = userMutableLiveData

    /*fun getUser(): MutableLiveData<LoginModel>? {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData
    }

    fun onClick(view: View?) {
        val loginUser = LoginModel()
        userMutableLiveData!!.setValue(loginUser)
    }*/


    fun loadTestData(mContext : Context, map: HashMap<String,String>) {
        showLoader.postValue(true)
        ApiServices.getBaseUrl()
                .loginUser(map)
                .enqueue(object : ApiCallbacks<LoginModel>() {
                    override fun onSuccess(response: LoginModel?) {
                        userMutableLiveData?.postValue(response)
                        if (response != null) {
                            CallingImportantMethod.showToast(mContext,response.token)
                        }
                    }

                    override fun onError(response: LoginModel?) {
                        CallingImportantMethod.showToast(mContext,"No response from server")
                    }

                    override fun onFailure(generalErrorMsg: String, systemErrorMsg: String) {
                        CallingImportantMethod.showToast(mContext,generalErrorMsg)
                    }
                })
    }

}