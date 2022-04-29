package com.prproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.prproject.model.ModelList
import com.prproject.model.PRData
import com.prproject.model.Response
import com.prproject.netwotk.Repository
import kotlinx.coroutines.launch

class NewsViewModel(app: Application) : AndroidViewModel(app) {

   private var servicesLiveData=MutableLiveData<Response>()

    fun getPRDataFromServer() {
        viewModelScope.launch {
         val res = Repository.getServicesApiCall()
            servicesLiveData.value = res
        }
    }
    fun getAllPRData(): LiveData<Response>? {
        return servicesLiveData
    }

    val message =MutableLiveData<PRData>()

    fun setMsgCommunicator(data: PRData){
        message.setValue(data)
    }

}