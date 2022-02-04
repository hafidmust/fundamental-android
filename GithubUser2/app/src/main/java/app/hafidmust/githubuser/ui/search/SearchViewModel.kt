package app.hafidmust.githubuser.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.hafidmust.githubuser.data.api.SearchResponse
import app.hafidmust.githubuser.networking.GithubAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    val searchModel: MutableLiveData<SearchResponse> = MutableLiveData()
    private lateinit var githubAPI: GithubAPI
    val showMessage: MutableLiveData<String> = MutableLiveData()

    fun onViewLoaded(username: String) {
        githubAPI = GithubAPI.getInstance().create(GithubAPI::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            val response = githubAPI.getSearch(username)
            if (response.isSuccessful) {
                if (response.body()?.items?.isEmpty() == true) {
                    showMessage.value = "Username tidak ditemukan !"
                } else {
                    searchModel.value = response.body()
                    showMessage.value = "${response.body()?.totalCount.toString()} Hasil Pencarian"
                }

            } else {
                showMessage.value = response.errorBody().toString()
            }
        }
    }

}