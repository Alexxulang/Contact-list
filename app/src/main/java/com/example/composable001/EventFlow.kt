package com.example.composable001

import android.content.Intent

sealed interface EventFlow {
    data class Call(val intent: Intent): EventFlow

}