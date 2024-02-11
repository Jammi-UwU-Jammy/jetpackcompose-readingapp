package com.vivich.starlitapp.utils

import androidx.annotation.StringRes

public final data class ErrorMessage(
    val id: Long,
    @StringRes val messageId: Int
)