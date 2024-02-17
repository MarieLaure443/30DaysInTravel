package com.example.a30daysintravel.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Travel(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val imageRes: Int
)
