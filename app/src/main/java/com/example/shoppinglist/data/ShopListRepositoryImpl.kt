package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl:ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementedId = 0

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Item with id $shopItemId not found")

    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = shopItem.id
        shopList.removeAt(oldElement)
        addShopItem(shopItem)
    }

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNNDEFINED_ID){
            shopItem.id = autoIncrementedId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.removeAt(shopItem.id)
    }
}