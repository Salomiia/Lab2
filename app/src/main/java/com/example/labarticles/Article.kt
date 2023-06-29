package com.example.labarticles

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(val title: String, val summary: String, val image: String, val content: String): Parcelable
