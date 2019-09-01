package com.dicoding.picodiploma.caribuku.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.caribuku.models.ItemsItem

abstract class BaseViewModel : ViewModel() {
    val observeBook: MutableLiveData<MutableList<ItemsItem>> = MutableLiveData()
    abstract fun getQueryBook(query: String)

}
