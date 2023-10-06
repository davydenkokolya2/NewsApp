package com.example.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemCategoryBinding
import com.example.newsapp.domain.CategoryCardModel

class CategoryViewAdapter(data: List<CategoryCardModel>, private val onClick:(Int, List<CategoryCardModel>) -> Unit) :
    RecyclerView.Adapter<CategoryViewAdapter.CardViewHolder>() {
    private var list: List<CategoryCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvItemCategory.setText(item.title)


        holder.binding.btnItemCategory.setOnClickListener {
            onClick(position, list)
        }
    }
}

