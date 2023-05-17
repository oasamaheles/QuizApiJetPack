package com.example.myallwork.ApiService

import com.example.myallwork.Model.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServise {

    @GET("services/1")
    suspend fun getAllServices(): Data

    companion object {
        private var apiService: ApiServise? = null

        fun geInstance(): ApiServise {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://tmkeensa.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiServise::class.java)
            }
            return apiService!!
        }
    }
}
