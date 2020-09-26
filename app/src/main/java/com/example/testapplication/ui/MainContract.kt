package com.example.testapplication.ui

import com.example.testapplication.model.News
import com.example.testapplication.utils.IProgressBar

interface MainContract {
    interface View: IProgressBar {

        fun onSuccssesGetListNews(list: News)
        fun onFailure()
    }
    interface Presenter{
        fun getNews()
    }
}