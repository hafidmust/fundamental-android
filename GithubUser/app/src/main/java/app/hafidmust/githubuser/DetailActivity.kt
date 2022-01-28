package app.hafidmust.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.hafidmust.githubuser.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val user = intent.getParcelableExtra<UsersItem>(EXTRA_USER) as UsersItem
        binding.apply {
            tvDName.text = user.name
            tvDUsername.text = user.username
            imgDAvatar.setImageResource(user.avatar)
            tvRepository.text = user.repository.toString()
            tvFollower.text = user.follower.toString()
            tvFollowing.text = user.following.toString()
            tvDLocation.text = user.location
            tvDCompany.text = user.company

            back.setOnClickListener {
                onBackPressed()
            }
        }

    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}