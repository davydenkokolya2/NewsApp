package com.example.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemInterestingBinding
import com.example.newsapp.domain.InterestingCardModel

class InterestingViewAdapter(
    data: List<InterestingCardModel>,
    private val onClick: (Int, List<InterestingCardModel>) -> Unit
) :
    RecyclerView.Adapter<InterestingViewAdapter.CardViewHolder>() {
    private var list: List<InterestingCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemInterestingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInterestingBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.ivItemInterestingImage.setImageResource(item.image)
        holder.binding.tvItemInterestingCategory.setText(item.category)
        holder.binding.tvItemInterestingTitle.setText(item.title)
        holder.binding.tvItemInterestingDescription.setText(item.predescription)

        holder.binding.btnItemInteresting.setOnClickListener {
            onClick(position, list)
        }
    }
}

