package com.example.testapplication

import android.app.Application
import com.example.testapplication.data.ForumService
import com.example.testapplication.data.Network

class StartApplication: Application() {
   private val BASE_URL="https://newsapi.org/"
  //  private val BASE_URL= "https://tezal.herokuapp.com"
    companion object {
        @Volatile
        lateinit var service: ForumService

    }

    override fun onCreate() {
        super.onCreate()
        service = Network.initService(BASE_URL)
    }
}