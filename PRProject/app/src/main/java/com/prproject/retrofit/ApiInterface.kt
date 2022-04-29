package com.prproject.retrofit

import com.prproject.model.ModelList
import com.prproject.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("everything?q=keyword&apiKey=4829f1e0719144d8835912db69e82572")
    suspend fun getServices(): Response

}