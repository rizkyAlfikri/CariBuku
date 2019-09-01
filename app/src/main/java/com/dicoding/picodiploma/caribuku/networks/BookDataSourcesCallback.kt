package com.dicoding.picodiploma.caribuku.networks

import com.dicoding.picodiploma.caribuku.models.Book

interface BookDataSourcesCallback {
    fun onSuccess(book: Book?)
    fun onFailed(errorMessage: String)
}