package com.vivich.starlitapp.data

import android.content.Context
import com.vivich.starlitapp.data.posts.PostsRepo
import com.vivich.starlitapp.data.samples.SamplePostRepo


interface AppContainer{
    val postsRepo : PostsRepo
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class lazyAppContainerImpl(private val applicationContext:Context) : AppContainer{
    override val postsRepo : PostsRepo by lazy {
        SamplePostRepo()
    }
}