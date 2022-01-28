package app.hafidmust.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.hafidmust.githubuser.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val user = intent.getParcelableExtra<UsersItem>(EXTRA_USER) as UsersItem
        binding.tvDName.text = user.name
        binding.tvDUsername.text = user.username
        binding.imgDAvatar.setImageResource(user.avatar)
        binding.tvRepository.text = user.repository.toString()
        binding.tvFollower.text = user.follower.toString()
        binding.tvFollowing.text = user.following.toString()
        binding.tvDLocation.text = user.location
        binding.tvDCompany.text = user.company

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}