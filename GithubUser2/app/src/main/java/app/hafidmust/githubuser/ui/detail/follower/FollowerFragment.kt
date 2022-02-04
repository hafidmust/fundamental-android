package app.hafidmust.githubuser.ui.detail.follower

import FollowAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.hafidmust.githubuser.databinding.FragmentFollowerBinding


class FollowerFragment : Fragment() {
    private lateinit var binding: FragmentFollowerBinding
    private lateinit var followerViewModel: FollowerViewModel

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        followerViewModel = ViewModelProvider(this).get(FollowerViewModel::class.java)
        binding = FragmentFollowerBinding.inflate(inflater, container, false)
        val followAdapter = FollowAdapter(listOf())
        val username = requireActivity().intent.getStringExtra(EXTRA_USERNAME)
        binding.rvFollower.adapter = followAdapter
        binding.progressbar.visibility = View.VISIBLE
        followerViewModel.onViewLoaded(username.toString())
        followerViewModel.followModel.observe(viewLifecycleOwner, {
            binding.progressbar.visibility = View.GONE
            followAdapter.update(it)
        })
        return binding.root
    }
}