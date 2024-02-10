package com.vivich.starlitapp.data

sealed class GETResult <out T>{
    data class Success<out T>(val data: T) : GETResult<T>()
    data class Error(val exception: Exception) : GETResult<Nothing>()
}

fun <T> GETResult<T>.successOr(fallback: T): T {
    return (this as? GETResult.Success<T>)?.data ?: fallback
}