package com.example.composable001

import android.content.Intent

import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow

import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ScreenViewModel : ViewModel() {
    private val _event = MutableSharedFlow<EventFlow>()
    val event = _event.asSharedFlow()

    private val dataList = listOf(
        ContactInfo(
            imageId = R.drawable.photo,
            name = "Alex",
            tel = "08998870",
            onClick = ::call,
        ),
        ContactInfo(
            imageId = R.drawable.photo,
            name = "Max",
            tel = "02837487",
            onClick = ::call,
        ),
    )
    val binding = ScreenViewBindings(
        list = dataList
    )

    private fun call(index: Int){

        val number = dataList[index].tel
        val intent = Intent(Intent.ACTION_DIAL, "tel:$number".toUri())

        viewModelScope.launch {
            _event.emit(EventFlow.Call(intent))
        }
    }





}
