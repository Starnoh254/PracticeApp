package com.starnoh.practice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes var string : Int ,
    var imageNo : Int,
    @DrawableRes var drawable : Int
)
