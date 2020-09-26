package com.example.testapplication.data

import com.example.testapplication.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ForumService {
    @Headers("Content-Type: application/json")
    @GET("v2/everything?q=bitcoin&from=2020-08-26&sortBy=publishedAt&apiKey=86160cc883dc433fa9025cf5bf5f744c")
   // @GET("/api/orgCategory/all")
    fun getListNews(): Call<News>
}