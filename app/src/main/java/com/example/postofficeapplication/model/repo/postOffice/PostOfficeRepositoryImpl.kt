package com.example.postofficeapplication.model.repo.postOffice

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.postofficeapplication.model.network.ApiClient
import com.example.postofficeapplication.model.pojo.PostOffice
import com.example.postofficeapplication.model.pojo.PostOfficeItem
import com.example.postofficeapplication.model.repo.Outcome

class PostOfficeRepositoryImpl(private val context: Context): PostOfficeRepository {
    private val apiService = ApiClient.getInstance(context)

    override suspend fun getPostOffice(postcode: String): Outcome<PostOffice> {
        val apiResponse = MutableLiveData<Outcome<PostOffice>>()
        try {
            val response = apiService.getPostOffice(postcode)
            apiResponse.value = Outcome.success(response!!)
        } catch (e: Throwable) {
            apiResponse.value = Outcome.failure(e)
        }

        return apiResponse.value as Outcome<PostOffice>
    }
}