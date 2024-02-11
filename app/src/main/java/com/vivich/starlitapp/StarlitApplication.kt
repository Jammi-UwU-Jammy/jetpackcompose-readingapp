package com.vivich.starlitapp

import android.app.Application
import com.vivich.starlitapp.data.AppContainer
import com.vivich.starlitapp.data.lazyAppContainerImpl

class StarlitApplication:Application(){
    companion object{
        const val STARLIT_APP_URI = "https://developer.android.com/jetnews"
    }

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = lazyAppContainerImpl(this)
    }
}