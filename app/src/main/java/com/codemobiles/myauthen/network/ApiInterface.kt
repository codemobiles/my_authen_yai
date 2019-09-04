package com.codemobiles.myauthen.network

import com.codemobiles.myauthen.models.TestJson
import com.codemobiles.myauthen.models.YoutubeResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/adhoc/youtubes/index_new.php")
    fun getYoutube(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("type") type: String
    ): Call<YoutubeResponse>


    @GET("/posts")
    fun getTestJson(): Call<List<TestJson>>

    companion object Factory {
        private val BASE_URL = "http://codemobiles.com"
        //private val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private var instance: Retrofit? = null

        fun getInstance(): ApiInterface {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!.create(ApiInterface::class.java)
        }
    }
}



