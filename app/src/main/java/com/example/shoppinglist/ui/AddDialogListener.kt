package com.example.shoppinglist.ui

import com.example.shoppinglist.model.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}