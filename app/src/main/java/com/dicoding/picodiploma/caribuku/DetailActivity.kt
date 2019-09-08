package com.dicoding.picodiploma.caribuku

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.caribuku.models.ItemsItem
import com.dicoding.picodiploma.caribuku.viewmodels.BookViewModel

class DetailActivity : BaseActivity<BookViewModel>() {

    private lateinit var txtTitle: TextView
    private lateinit var txtAuthors: TextView
    private lateinit var rattingBar: RatingBar
    private lateinit var txtPubliser: TextView
    private lateinit var txtPublisedDate: TextView
    private lateinit var txtInfo: TextView
    private lateinit var imgBanner: ImageView
    private lateinit var imgPhoto: ImageView
    private lateinit var progressBar: ProgressBar

    companion object {
        const val EXTRA_BOOK: String = "extra_book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txtTitle = findViewById(R.id.txt_title)
        txtAuthors = findViewById(R.id.txt_authors)
        rattingBar = findViewById(R.id.ratting_bar)
        txtPubliser = findViewById(R.id.txt_publiser)
        txtPublisedDate = findViewById(R.id.txt_publised_date)
        txtInfo = findViewById(R.id.txt_info)
        imgPhoto = findViewById(R.id.img_photo)
        imgBanner = findViewById(R.id.img_banner)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        val idBook: String = intent.getStringExtra(EXTRA_BOOK)
        bookViewModel.observeBook.observe(this, detailBookObserable())
        bookViewModel.getQueryBook(idBook)
    }

    private fun detailBookObserable(): Observer<MutableList<ItemsItem>> = Observer { it ->
        it?.let {
            progressBar.visibility = View.GONE
            txtTitle.text = it[0].volumeInfo.title
            txtAuthors.text = it[0].volumeInfo.authors[0] ?: "-"
            rattingBar.rating = it[0].volumeInfo.averageRating.toFloat()
            txtPubliser.text = it[0].volumeInfo.publisher ?: "-"
            txtPublisedDate.text = it[0].volumeInfo.publishedDate ?: "-"
            txtInfo.text = it[0].searchInfo.textSnippet ?: "No description"

            Glide.with(applicationContext).load(it[0].volumeInfo.imageLinks.thumbnail)
                .apply { RequestOptions() }.into(imgPhoto)

            Glide.with(applicationContext).load(it[0].volumeInfo.imageLinks.thumbnail)
                .apply { RequestOptions() }.into(imgBanner)
        }
    }

    override fun provideViewModelClass(): Class<BookViewModel> {
        return BookViewModel::class.java
    }
}
