package com.dicoding.picodiploma.caribuku.networks

import android.util.Log
import com.dicoding.picodiploma.caribuku.models.Book
import com.dicoding.picodiploma.caribuku.utils.BuildConfig.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookDataSources {
    fun getBooks(query: String, callback: BookDataSourcesCallback) {
        val requestInterface: IApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IApiService::class.java)

        requestInterface.getBookFromRetrofit(query).enqueue(object : Callback<Book?> {
            override fun onFailure(call: Call<Book?>, t: Throwable) {
                Log.e("Gagal mendapatkan data", t.message)
                callback.onFailed("Terjadi kesalahan saat menghubungi server")
            }

            override fun onResponse(call: Call<Book?>, response: Response<Book?>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body())
                        Log.d("berhasil", response.errorBody().toString())
                    } else {
                        Log.d("daa null", response.errorBody().toString())
                    }
                }
                Log.d("Gagal success", response.errorBody().toString())
            }
        })
    }
}