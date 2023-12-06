package org.sirekanyan.github

import android.app.Application
import android.content.Context
import org.sirekanyan.github.data.GithubApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun Context.app(): App =
    applicationContext as App

class App : Application() {

    val githubApi: GithubApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

}
