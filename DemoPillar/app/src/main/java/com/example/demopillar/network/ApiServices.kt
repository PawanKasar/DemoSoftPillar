package com.example.demopillar.network

import com.example.demopillar.Utilities.URls
import com.example.demopillar.model.LoginModel

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ApiServices {

    companion object {

        /**
         * @return Instance of RetrofitAPI class
         */
        fun getBaseUrl(): ApiServices {

            val instance: ApiServices by lazy {
                val retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getClient())
                        .baseUrl(URls.BASE_URL)
                        .build()
                retrofit.create(ApiServices::class.java)
            }

            return instance
        }

        /**
         * @return Instance of OkHttpClient class with modified timeout
         */
        private fun getClient(): OkHttpClient {
            val httpTimeout: Long = 20
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.connectTimeout(httpTimeout, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(httpTimeout, TimeUnit.SECONDS)
            return okHttpClientBuilder.build()
        }
    }

    @POST("login")
    fun loginUser(@Body map: HashMap<String,String>) : Call<LoginModel>

}