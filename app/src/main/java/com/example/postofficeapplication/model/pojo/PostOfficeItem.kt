package com.example.postofficeapplication.model.pojo


import com.google.gson.annotations.SerializedName

data class PostOfficeItem(
    @SerializedName("Message")
    val message: String,
    @SerializedName("PostOffice")
    val postOffice: List<PostOfficeX>,
    @SerializedName("Status")
    val status: String
)