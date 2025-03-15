package com.example.composable001


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactList(viewModel.binding.list)

        }
        handleEvent(viewModel.event)

    }

    private fun handleEvent(flow: Flow<EventFlow>) {
        lifecycleScope.launch {
            flow.collect {
                when (it) {
                    is EventFlow.Call -> startActivity(it.intent)
                }
            }
        }

    }


}

