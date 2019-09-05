package com.codemobiles.myauthen.network

import com.codemobiles.myauthen.models.TestJSON
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface TestApiInterface {


    @GET("/users")
    fun testJson(): Call<List<TestJSON>>

    companion object Factory {

        private val BASE_URL = "https://jsonplaceholder.typicode.com"

        private var instance: Retrofit? = null

        fun getInstance(): TestApiInterface {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!.create(TestApiInterface::class.java)
        }
    }
}



