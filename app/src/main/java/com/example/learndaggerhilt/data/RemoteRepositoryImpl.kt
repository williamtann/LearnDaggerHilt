package com.example.learndaggerhilt.data

import android.content.Context
import android.widget.Toast
import com.example.learndaggerhilt.domain.RemoteRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteApi: RemoteApi,
    @ApplicationContext private val context: Context
) : RemoteRepository {

    init {
        Toast.makeText(context, "Repository injected!", Toast.LENGTH_SHORT).show()
    }

    override suspend fun fetchData() {
        remoteApi.doNetworkCall()
    }
}