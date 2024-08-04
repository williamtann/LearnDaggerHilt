package com.example.learndaggerhilt.data

import retrofit2.http.GET

interface RemoteApi {

    @GET("test")
    suspend fun doNetworkCall()
}