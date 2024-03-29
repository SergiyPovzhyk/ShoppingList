package com.example.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopItems")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val count:Int,
    var enabled:Boolean,

)
