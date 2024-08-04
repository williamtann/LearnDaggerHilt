package com.example.learndaggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("welcomeText")
    lateinit var welcomeMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainScreen(welcomeMessage)
        }
    }
}

@Composable
fun MainScreen(welcomeMessage: String, viewModel: MainViewModel = hiltViewModel()) {
    /**
     * we can also construct a view model class with hiltViewModel() as below
     */
//    val viewModel = hiltViewModel<MainViewModel>()
    viewModel.fetchData()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = welcomeMessage)
    }
}