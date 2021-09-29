package com.example.postofficeapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.postofficeapplication.model.repo.postOffice.PostOfficeRepository

class PostOfficeViewModel(private val postOfficeRepository: PostOfficeRepository): ViewModel() {

    fun getPostOffice(postcode: String) = liveData {
        emit(postOfficeRepository.getPostOffice(postcode))
    }
}