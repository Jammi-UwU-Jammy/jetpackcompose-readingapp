package com.vivich.starlitapp.data

import android.app.Application
import android.content.Context


interface AppContainer {

}

class LazyAppContainerImpl (private val applicationContext: Context) : AppContainer{

}