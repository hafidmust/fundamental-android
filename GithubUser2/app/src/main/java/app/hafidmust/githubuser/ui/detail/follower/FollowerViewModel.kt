package app.hafidmust.githubuser.ui.detail.follower

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.hafidmust.githubuser.data.api.FollowResponseItem
import app.hafidmust.githubuser.networking.GithubAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FollowerViewModel : ViewModel() {
    private lateinit var githubAPI: GithubAPI
    val followModel: MutableLiveData<List<FollowResponseItem>> = MutableLiveData()
    fun onViewLoaded(username: String) {
        githubAPI = GithubAPI.getInstance().create(GithubAPI::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            val response = githubAPI.getDetailFollower(username)
            if (response.isSuccessful) {
                followModel.value = response.body()
            }
        }
    }
}