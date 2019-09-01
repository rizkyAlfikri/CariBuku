package com.dicoding.picodiploma.caribuku.networks

import com.dicoding.picodiploma.caribuku.models.Book
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("volumes")
    fun getBookFromRetrofit(@Query("q") query: String): Call<Book>
}