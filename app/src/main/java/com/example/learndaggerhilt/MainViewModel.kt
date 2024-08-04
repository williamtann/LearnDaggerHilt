package com.example.learndaggerhilt

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learndaggerhilt.domain.RemoteRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val remoteRepository: Lazy<RemoteRepository>
) : ViewModel() {

    fun fetchData() {
        viewModelScope.launch {
            try {
                delay(3_000)
                remoteRepository.get().fetchData()
            } catch (e: Exception) {
                Log.e("network request", e.toString())
            }
        }
    }
}