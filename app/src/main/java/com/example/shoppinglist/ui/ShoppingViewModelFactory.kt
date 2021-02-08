package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.model.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(val repository: ShoppingRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingViewModel::class.java)) {
            return ShoppingViewModel(repository) as T
        }
        throw IllegalArgumentException("unknown model class")
    }

}