package com.dicoding.picodiploma.caribuku.viewmodels

import com.dicoding.picodiploma.caribuku.models.Book
import com.dicoding.picodiploma.caribuku.networks.BookDataSources
import com.dicoding.picodiploma.caribuku.networks.BookDataSourcesCallback

class BookViewModel: BaseViewModel() {
    override fun getQueryBook(query: String) {
        val bookDataSource = BookDataSources()
        bookDataSource.getBooks(query, callback = object: BookDataSourcesCallback {
            override fun onSuccess(book: Book?) {
                observeBook.postValue(book?.items)
            }

            override fun onFailed(errorMessage: String) {

            }
        })
    }
}