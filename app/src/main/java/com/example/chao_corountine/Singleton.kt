package com.example.chao_corountine

import com.example.chao_corountine.models.School

object Singleton {
    val schoolSingleton: School by lazy {
        School(address = "apple tree", schoolName = "apple university", image = "image.png")
    }
}