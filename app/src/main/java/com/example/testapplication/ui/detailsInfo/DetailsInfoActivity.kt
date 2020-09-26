package com.example.testapplication.ui.detailsInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.testapplication.R
import kotlinx.android.synthetic.main.activity_details_info.*
import kotlinx.android.synthetic.main.item_list.view.*

class DetailsInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_info)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);

        val bundle = intent.extras
        if (bundle != null) {
            val author = bundle.getString("author")
            val content = bundle.getString("content")
            val description = bundle.getString("description")
            val publishedAt = bundle.getString("publishedAt")
            val title = bundle.getString("title")
            val url = bundle.getString("url")
            val urlToImage = bundle.getString("urlToImage")
            Toast.makeText(this,"item :"+author, Toast.LENGTH_SHORT).show()
            Glide.with(this).load(urlToImage).into(idImgView)
            idAuthor.text = author.toString()
            idContent.text = content.toString()
            idTitle.text = title.toString()
            idDescription.text= description.toString()
            idPublishedAt.text = publishedAt.toString()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0);
    }
}