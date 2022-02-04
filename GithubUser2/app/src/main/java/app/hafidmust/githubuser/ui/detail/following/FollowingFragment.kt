package app.hafidmust.githubuser.ui.detail.following

import FollowAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import app.hafidmust.githubuser.databinding.FragmentFollowingBinding


class FollowingFragment : Fragment() {
    private lateinit var binding : FragmentFollowingBinding
    private lateinit var followingViewModel: FollowingViewModel

    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        followingViewModel = ViewModelProvider(this).get(FollowingViewModel::class.java)

        binding = FragmentFollowingBinding.inflate(inflater, container,false)
        val followAdapter = FollowAdapter(listOf())
        val username = requireActivity().intent.getStringExtra(EXTRA_USERNAME)
        binding.rvFollowing.adapter = followAdapter
        binding.progressbar.visibility = View.VISIBLE
        followingViewModel.onViewLoaded(username.toString())
        followingViewModel.followModel.observe(viewLifecycleOwner,{
            followAdapter.update(it)
            binding.progressbar.visibility = View.GONE
        })

        return binding.root
    }
}