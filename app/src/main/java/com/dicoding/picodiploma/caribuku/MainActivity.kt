package com.dicoding.picodiploma.caribuku

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.picodiploma.caribuku.adapters.BookAdapter
import com.dicoding.picodiploma.caribuku.models.ItemsItem
import com.dicoding.picodiploma.caribuku.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<BookViewModel>() {


    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_circular.visibility = VISIBLE
        bookAdapter = BookAdapter(this)
        rv_book.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            setHasFixedSize(true)
            adapter = bookAdapter
        }

        bookViewModel.observeBook.observe(this, bookObserable())
        bookViewModel.getQueryBook("Android")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchManager: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = getString(R.string.cari_buku)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { bookViewModel.getQueryBook(it) }
                progress_circular.visibility = VISIBLE
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_setting -> {
                val settingIntent = Intent(this, AboutActivity::class.java)
                startActivity(settingIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun bookObserable(): Observer<MutableList<ItemsItem>> = Observer {
        bookAdapter.setListBook(it)
        progress_circular.visibility = GONE

    }

    override fun provideViewModelClass(): Class<BookViewModel> {
        return BookViewModel::class.java
    }
}
