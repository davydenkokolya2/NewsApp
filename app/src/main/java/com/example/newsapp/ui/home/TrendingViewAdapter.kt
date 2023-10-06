package com.example.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemTrendingBinding
import com.example.newsapp.domain.InterestingCardModel

class TrendingViewAdapter(
    data: List<InterestingCardModel>,
    private val onClick: (Int, List<InterestingCardModel>) -> Unit
) :
    RecyclerView.Adapter<TrendingViewAdapter.CardViewHolder>() {
    private var list: List<InterestingCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemTrendingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTrendingBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.ivTrendingImage.setImageResource(item.image)
        holder.binding.tvItemTrendingTitle.setText(item.title)
        holder.binding.tvItemTrendingDescription.setText(item.predescription)

        holder.binding.btnItemTrending.setOnClickListener {
            onClick(position, list)
        }
    }
}

