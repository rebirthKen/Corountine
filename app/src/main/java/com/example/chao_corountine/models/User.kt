package com.example.chao_corountine.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class School(
        @Expose
        @SerializedName("address")
        val address: String? = null,

        @Expose
        @SerializedName("schoolName")
        val schoolName: String? = null,

        @Expose
        @SerializedName("image")
        val image: String? = null
){
    override fun toString(): String {
        return "User(address=$address, schoolName=$schoolName, image=$image)"
    }
}