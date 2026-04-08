package com.example.githubsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubsearch.data.network.RetrofitClient
import com.example.githubsearch.data.repository.UserRepository
import com.example.githubsearch.ui.main.UserSearchScreen
import com.example.githubsearch.ui.theme.GitHubSearchTheme
import com.example.githubsearch.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository(RetrofitClient.apiInterface)
        val viewModel = UserViewModel(repository)

        setContent {
            MaterialTheme{Surface(color = MaterialTheme.colorScheme.background) {
                UserSearchScreen(viewModel)}
            }
        }
    }
}
