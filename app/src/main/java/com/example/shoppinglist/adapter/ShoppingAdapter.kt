package com.example.shoppinglist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.model.db.entities.ShoppingItem
import com.example.shoppinglist.ui.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(
    val context: Context,
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel): RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = currentShoppingItem.amount.toString()

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItem.amount > 1) {
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }else{
             Toast.makeText(context, "amount must be greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}