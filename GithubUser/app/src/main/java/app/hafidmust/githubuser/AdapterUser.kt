package app.hafidmust.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.hafidmust.githubuser.databinding.AdapterUserBinding

class AdapterUser(var data : List<UsersItem>, val listener : EventListener) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {
    interface EventListener{
        fun click(item : UsersItem)
    }
    inner class ViewHolder(val binding : AdapterUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(usersItem: UsersItem){
            binding.imgAvatar.setImageResource(usersItem.avatar)
            binding.tvFullName.text = usersItem.name
            binding.tvUsername.text = usersItem.username
            binding.tvLocation.text = usersItem.company

            binding.root.setOnClickListener {
                listener.click(usersItem)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterUserBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}