package com.dicoding.picodiploma.caribuku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<T : ViewModel> : AppCompatActivity() {
    lateinit var bookViewModel: T

    abstract fun provideViewModelClass(): Class<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bookViewModel = ViewModelProviders.of(this).get(provideViewModelClass())
    }
}
