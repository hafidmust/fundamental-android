package app.hafidmust.githubuser.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.hafidmust.githubuser.data.api.ItemsItem
import app.hafidmust.githubuser.databinding.AdapterUserBinding
import com.bumptech.glide.Glide

class AdapterSearch(var data: List<ItemsItem>, val listener: EventListener) :
    RecyclerView.Adapter<AdapterSearch.ViewHolder>() {
    interface EventListener {
        fun click(item: ItemsItem)
    }

    inner class ViewHolder(val binding: AdapterUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemsItem: ItemsItem) {
            Glide.with(binding.root).load(itemsItem.avatarUrl).into(binding.imgAvatar)
            binding.tvUsername.text = itemsItem.login
            binding.root.setOnClickListener {
                listener.click(itemsItem)
            }
        }
    }

    fun update(data: List<ItemsItem>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterUserBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}