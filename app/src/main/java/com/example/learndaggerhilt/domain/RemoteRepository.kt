package com.example.learndaggerhilt.domain

interface RemoteRepository {

    suspend fun fetchData()
}