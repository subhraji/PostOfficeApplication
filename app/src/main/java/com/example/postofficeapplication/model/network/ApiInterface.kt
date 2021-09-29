package com.example.postofficeapplication.model.network

import com.example.postofficeapplication.model.pojo.PostOffice
import com.example.postofficeapplication.model.pojo.PostOfficeItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/pincode/{postcode}")
    suspend fun getPostOffice(
        @Path("postcode") postcode: String,
        ): PostOffice?
}