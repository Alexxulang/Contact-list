package com.example.composable001


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactList(list: List<ContactInfo>) {

    Column(
        modifier = Modifier.fillMaxSize().padding(
            top = 30.dp
        )
    ) {
        list.forEachIndexed { index, contactInfo ->
            Contact(contactInfo = contactInfo, index = index)
        }



    }
}

@Composable
fun Contact(contactInfo: ContactInfo, index:Int) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable{
           contactInfo.onClick(index) },


        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(contactInfo.imageId),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(all = 10.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                "Name: ${contactInfo.name}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Tel: ${contactInfo.tel}",
                fontSize = 15.sp,
                fontWeight = FontWeight.W700,
            )
        }

        Image(
            modifier = Modifier.padding(15.dp),
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }

}

@Composable
@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
fun ContactPreview() {
    Contact(
        contactInfo = ContactInfo(
            imageId = R.drawable.photo,
            name = "Alex",
            tel = "08998870",
            onClick = {},
        ),
        index = 0,
    )
}

@Composable
@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
fun ContactListPreview() {
    ContactList(
        listOf(
            ContactInfo(
                imageId = R.drawable.photo,
                name = "Alex",
                tel = "08998870",
                onClick = {},
            ),
            ContactInfo(
                imageId = R.drawable.photo,
                name = "Max",
                tel = "02837487",
                onClick = {},
            ),


        )

    )





}