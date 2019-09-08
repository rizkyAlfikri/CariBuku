package com.dicoding.picodiploma.caribuku.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.caribuku.DetailActivity
import com.dicoding.picodiploma.caribuku.R
import com.dicoding.picodiploma.caribuku.models.ItemsItem
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter(private val context: Context) : RecyclerView.Adapter<BookAdapter.BookHolder>() {
    private var listBook: MutableList<ItemsItem>? =  null

    fun setListBook(listBook: MutableList<ItemsItem>) {
        this.listBook = listBook
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookHolder(view)
    }

    override fun getItemCount(): Int = listBook?.size ?: 0

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.apply {
            txtTitle.text = listBook?.get(position)?.volumeInfo?.title
            txtAuthors.text = listBook?.get(position)?.volumeInfo?.authors?.get(0) ?: "-"
            ratingBar.rating = listBook?.get(position)?.volumeInfo?.averageRating?.toFloat() ?: 0F
            Glide.with(context).load(listBook?.get(position)?.volumeInfo?.imageLinks?.thumbnail)
                .apply(RequestOptions()).into(imgTumbnail)

            cardView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_BOOK, listBook?.get(position)?.id)
                context.startActivity(intent)
            }
        }
    }


    class BookHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtTitle: TextView = view.txt_title
        var txtAuthors: TextView = view.txt_authors
        var ratingBar: RatingBar = view.ratting_bar
        var imgTumbnail: ImageView = view.img_tumbnail
        var cardView: CardView = view.findViewById(R.id.card_view)
    }

}