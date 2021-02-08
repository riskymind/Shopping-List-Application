package com.example.shoppinglist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class Shopping_item(
    var name: String,
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}