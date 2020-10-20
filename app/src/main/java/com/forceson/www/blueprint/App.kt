package com.forceson.www.blueprint

import android.app.Application
import android.content.Context

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        private var context: Context? = null

        fun getAppContext(): Context = context!!
    }
}