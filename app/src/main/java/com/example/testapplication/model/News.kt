package com.example.testapplication.model
import com.google.gson.annotations.SerializedName
data class News (
         val articles: List<Article> = listOf(),
         val status: String = "",
         val totalResults: Int = 0
     )
