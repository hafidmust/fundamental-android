package app.hafidmust.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import app.hafidmust.githubuser.R
import app.hafidmust.githubuser.databinding.ActivityDetailBinding
import app.hafidmust.githubuser.ui.detail.following.FollowingFragment
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_USER = "extra_user"
        private val TAB_TITLES = intArrayOf(R.string.text_tab1, R.string.text_tab2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        val username = intent.getStringExtra(EXTRA_USERNAME)
        Log.d("getUsername", username.toString())

        val bundle = Bundle()
        bundle.putString(FollowingFragment.EXTRA_USERNAME, username.toString())
        val fragFollowing = FollowingFragment()
        fragFollowing.arguments = bundle

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        username?.let { detailViewModel.onViewLoaded(it) }
        binding.progressbar.visibility = View.VISIBLE
        detailViewModel.detailModel.observe(this, {
            binding.progressbar.visibility = View.GONE
            binding.tvDName.text = it.name
            Glide.with(this).load(it.avatarUrl).into(binding.imgDAvatar)
            binding.tvDUsername.text = it.login
            binding.tvRepository.text = it.publicRepos.toString()
            binding.tvFollower.text = it.followers.toString()
            binding.tvFollowing.text = it.following.toString()
            binding.tvDLocation.text = it.location
            binding.tvDCompany.text = it.company
        })
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }


}