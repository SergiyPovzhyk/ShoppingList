package com.example.shoppinglist.domain

data class ShopItem(
    val name:String,
    val count:Int,
    val enabled:Boolean,
    var id:Int = UNNDEFINED_ID
){
    companion object {
        const val UNNDEFINED_ID = -1
    }
}


