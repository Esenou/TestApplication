package com.example.testapplication.ui

import com.example.testapplication.StartApplication
import com.example.testapplication.model.News

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View):MainContract.Presenter {

    override fun getNews() {
        if (isViewAttached()) {
            view.showProgress()
            StartApplication.service.getListNews().enqueue(
                object : Callback<News> {
                    override fun onFailure(
                        call: Call<News>?,
                        t: Throwable?
                    ) {
                        if (isViewAttached()) {
                            view.hideProgress()
                        }
                        t?.printStackTrace()
                    }

                    override fun onResponse(
                        call: Call<News>?,
                        response: Response<News>?
                    ) {
                        if (isViewAttached()) {
                            if (response!!.isSuccessful && response != null) {
                                view.onSuccssesGetListNews(response.body()!!)

                            } else
                                view.onFailure()
                            view.hideProgress()
                        }
                    }
                }
            )
        }
    }
    fun isViewAttached(): Boolean = view != null

}