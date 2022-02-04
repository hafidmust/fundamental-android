package app.hafidmust.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import app.hafidmust.githubuser.ui.detail.follower.FollowerFragment
import app.hafidmust.githubuser.ui.detail.following.FollowingFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = FollowingFragment()
            1 -> fragment = FollowerFragment()
        }
        return fragment as Fragment
    }
}