package com.prproject.netwotk

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.prproject.model.ModelList
import com.prproject.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    //val serviceSetterGetter = MutableLiveData<ModelList>()

  suspend fun getServicesApiCall():com.prproject.model.Response {

        val call = RetrofitClient.apiInterface.getServices()
         //serviceSetterGetter.value = call
//        call.enqueue(object : Callback<ModelList> {
//            override fun onFailure(call: Call<ModelList>, t: Throwable) {
//                Log.v("DEBUG : ", t.message.toString())
//            }
//            override fun onResponse(
//                call: Call<ModelList>,
//                response: Response<ModelList>
//            ) {
//                Log.v("DEBUG : ", response.body().toString())
//                val data = response.body()
//                serviceSetterGetter.value = data
//            }
//        })

        return call
    }
}