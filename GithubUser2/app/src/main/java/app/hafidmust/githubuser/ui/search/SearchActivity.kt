package app.hafidmust.githubuser.ui.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import app.hafidmust.githubuser.data.api.ItemsItem
import app.hafidmust.githubuser.databinding.ActivitySearchBinding
import app.hafidmust.githubuser.ui.detail.DetailActivity

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        binding.svUser.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        val searchAdapter = AdapterSearch(listOf(), object : AdapterSearch.EventListener {
            override fun click(item: ItemsItem) {
                val intentWithDataUsername =
                    Intent(this@SearchActivity, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_USERNAME, item.login.toString())
                        putExtra(DetailActivity.EXTRA_USER, item)
                    }
                startActivity(intentWithDataUsername)
            }
        })
        binding.rvSearchUser.adapter = searchAdapter



        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    binding.svUser.clearFocus()
                    searchViewModel.onViewLoaded(query.toString())
                    searchViewModel.searchModel.observe(this@SearchActivity, {
                        searchAdapter.update(it.items as List<ItemsItem>)
                        showloading(false)
                    })
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isEmpty() == true){
                    showloading(false)
                }else{
                    showloading(true)
                }
                return false
            }
        })
        searchViewModel.showMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            binding.progressbar.visibility = View.GONE
        })

    }

    private fun showloading(show: Boolean) {
        if(show){
            binding.progressbar.visibility = View.VISIBLE
        }else{
            binding.progressbar.visibility = View.GONE
        }
    }
}