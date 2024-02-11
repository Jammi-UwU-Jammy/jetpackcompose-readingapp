package com.vivich.starlitapp.data.posts

import com.vivich.starlitapp.data.GETResult
import com.vivich.starlitapp.model.post.Post
import com.vivich.starlitapp.model.post.PostsFeed
import kotlinx.coroutines.flow.Flow

interface PostsRepo {
    suspend fun getPost(postId: String?) : GETResult<Post>
    suspend fun getPostsFeed(): GETResult<PostsFeed>
    fun observeFavorites(): Flow<Set<String>>
    fun observePostsFeed(): Flow<PostsFeed?>
    suspend fun toggleFavorite(postId: String)

}