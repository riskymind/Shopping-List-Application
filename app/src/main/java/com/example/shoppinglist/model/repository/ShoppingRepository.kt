package com.example.shoppinglist.model.repository

import com.example.shoppinglist.model.db.ShoppingDatabase
import com.example.shoppinglist.model.db.entities.ShoppingItem

class ShoppingRepository(val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItems()
}