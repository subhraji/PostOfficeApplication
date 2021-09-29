package com.example.postofficeapplication.model.repo.postOffice

import com.example.postofficeapplication.model.pojo.PostOffice
import com.example.postofficeapplication.model.pojo.PostOfficeItem
import com.example.postofficeapplication.model.repo.Outcome

interface PostOfficeRepository {
    suspend fun getPostOffice(postcode: String): Outcome<PostOffice>
}