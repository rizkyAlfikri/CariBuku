package com.dicoding.picodiploma.caribuku.networks

import com.dicoding.picodiploma.caribuku.utils.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

abstract class RetrofitService {
    companion object {
        private var retrofit: Retrofit? = null
        fun createService(serviceClass: IApiService): IApiService? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(serviceClass::class.java)
        }
    }
}