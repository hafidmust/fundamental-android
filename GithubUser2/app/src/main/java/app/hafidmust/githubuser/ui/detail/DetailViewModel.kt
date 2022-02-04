package app.hafidmust.githubuser.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.hafidmust.githubuser.data.api.DetailResponse
import app.hafidmust.githubuser.networking.GithubAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    val detailModel : MutableLiveData<DetailResponse> = MutableLiveData()
    private lateinit var githubAPI: GithubAPI
    fun onViewLoaded(username: String){
        githubAPI = GithubAPI.getInstance().create(GithubAPI::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            val response = githubAPI.getDetail(username)
            if (response.isSuccessful){
                detailModel.value = response.body()
            }
        }
    }
}