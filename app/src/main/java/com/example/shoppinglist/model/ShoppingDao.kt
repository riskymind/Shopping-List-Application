package com.example.shoppinglist.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingDao {
    @Insert
    suspend fun upsert(item: Shopping_item)

    @Delete
    suspend fun delete(item: Shopping_item)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<Shopping_item>>
}