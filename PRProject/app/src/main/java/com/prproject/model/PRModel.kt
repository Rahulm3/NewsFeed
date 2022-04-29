package com.prproject.model


data class PRData(
    val author: String,
    val urlToImage: String,
    val publishedAt: String,
    val description: String
)

data class Response(val status: String,
                    val totalResults: Int,
                    val articles:ModelList)

class ModelList : ArrayList<PRData>()