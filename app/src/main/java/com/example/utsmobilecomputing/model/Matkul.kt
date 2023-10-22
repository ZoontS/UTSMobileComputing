package com.example.utsmobilecomputing.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Matkul (
    @StringRes val matkulRes: Int,
    @StringRes val sksRes: Int,
    @DrawableRes val logoRes: Int,
)