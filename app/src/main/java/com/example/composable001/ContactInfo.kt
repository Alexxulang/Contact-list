package com.example.composable001

data class ContactInfo(
    val imageId:Int,
    val name: String,
    val tel: String,
    val onClick: (Int) -> Unit,

        )
