package com.example.composable001

class ListTest {
}

fun main() {
    for (i in 1..10){
        println(i)
    }

    val list = listOf(1,2,3,4)
    val listString = listOf("Hello", "Goodbye")
    val contactInfo = listOf(ContactInfo(
        imageId = R.drawable.photo,
        name = "Max",
        tel = "02837487",
        onClick = {}
    )
    )
    contactInfo.forEach{
        println(it.name)
        println(it.tel)
    }

    for (i in list){
        println(i)
    }

    list.forEach{
        println(it)
    }

    list.forEachIndexed{index, value->
        println("index is $index, value is $value")
    }


}