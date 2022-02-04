import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.hafidmust.githubuser.data.api.FollowResponseItem
import app.hafidmust.githubuser.databinding.AdapterFollowBinding

import com.bumptech.glide.Glide

class FollowAdapter(var data: List<FollowResponseItem>) :
    RecyclerView.Adapter<FollowAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: AdapterFollowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FollowResponseItem) {
            Glide.with(binding.root).load(item.avatarUrl)
                .circleCrop()
                .into(binding.ivAvatar)
            binding.tvUsername.text = item.login
        }
    }

    fun update(data: List<FollowResponseItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterFollowBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}