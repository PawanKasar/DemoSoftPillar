package com.example.demopillar.network


import com.example.demopillar.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class ApiCallbacks<T> : Callback<T> {

    /**
     * @param call     Instance of Call interface.
     * @param response Response of the API to determine if it indicates success.
     */
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful && response.body() != null) {
            if (response.body() is LoginModel)
                onSuccess(response.body())
            else
                onError(response.body())

        } else onFailure(call, Exception())

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure("Failure", t.message ?: "")
    }

    /**
     * @param response If not null and status is equal to 1 then sends response to the activity.
     */
    protected abstract fun onSuccess(response: T?)

    /**
     * @param response If not null and status is equal to 0 then sends response to the activity.
     */
    protected abstract fun onError(response: T?)

    /**
     * @param generalErrorMsg UserData defined error message.
     * @param systemErrorMsg  System defined error message.
     */
    protected abstract fun onFailure(generalErrorMsg: String, systemErrorMsg: String)
}