package com.example.testapplication.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.baoyz.widget.PullRefreshLayout
import com.example.testapplication.R
import com.example.testapplication.model.Article
import com.example.testapplication.model.News
import com.example.testapplication.ui.detailsInfo.DetailsInfoActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class MainActivity : AppCompatActivity() , MainContract.View,MainAdapter.Listener{

    lateinit var presenter: MainPresenter
    lateinit var adapter: MainAdapter
    var swipeNews: PullRefreshLayout? = null
    val objectOutputStream:ObjectOutputStream? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        swipeNews = findViewById(R.id.swipeNews)
        swipeNews?.setOnRefreshListener {
            // Do work to refresh the list here.
            init()
        }
        /*val fileOutputStream: FileOutputStream = this.openFileOutput("esen", Context.MODE_PRIVATE)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)*/
    }

    fun init() {
        presenter = MainPresenter(this)
        presenter.getNews()
    }

    override fun onSuccssesGetListNews(list: News) {
        objectOutputStream?.writeObject(list)
        objectOutputStream?.close()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewList?.layoutManager = GridLayoutManager(this, 10)
        recyclerViewList?.layoutManager = layoutManager
        adapter = MainAdapter(list.articles, this)
        recyclerViewList.adapter = adapter
    }

    override fun onFailure() {
        Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        swipeNews?.setRefreshing(true)
    }
    override fun hideProgress() {
        swipeNews?.setRefreshing(false)
    }
    override fun setOnItemClick(position: Article) {
        val intent = Intent(this, DetailsInfoActivity::class.java)
        val bundle = Bundle()
        bundle.putString("author", position.author)
        bundle.putString("content", position.content)
        bundle.putString("description",position.description)
        bundle.putString("publishedAt",position.publishedAt)
        bundle.putString("title",position.title)
        bundle.putString("url", position.url)
        bundle.putString("urlToImage",position.urlToImage)
        intent.putExtras(bundle)
        startActivity(intent)
       // Toast.makeText(this,"item :"+position,Toast.LENGTH_SHORT).show()
    }
}