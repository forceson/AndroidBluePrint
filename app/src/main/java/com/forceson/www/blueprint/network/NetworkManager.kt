package com.forceson.www.blueprint.network

import com.forceson.www.blueprint.App
import com.forceson.www.blueprint.BuildConfig
import com.forceson.www.blueprint.R
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .header("Authorization", App.getAppContext().getString(R.string.API_AUTH_TOKEN))
                    .build()
            )
        }

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    fun getApiService(): ApiService {
        val gsonBuilder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val retrofit = Retrofit.Builder()
            .baseUrl(App.getAppContext().getString(R.string.BASE_URL))
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}