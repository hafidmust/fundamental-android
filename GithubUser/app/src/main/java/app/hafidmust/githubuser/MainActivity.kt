package app.hafidmust.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.hafidmust.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listUser = listOf(
            UsersItem(
                follower = 56995,
                following = 12,
                name = "Jake Wharton",
                company = "Google, Inc",
                location = "Pittsburgh, PA, USA",
                avatar = R.drawable.user1,
                repository = 102,
                username = "JakeWharton"
            ),
            UsersItem(
                follower = 5153,
                following = 2,
                name = "Amit Shekhar",
                company = "MindOrksOpenSource",
                location = "New Delhi, India",
                avatar = R.drawable.user2,
                repository = 37,
                username = "amitshekhariitbhu"
            ),
            UsersItem(
                follower = 7972,
                following = 0,
                name = "Romain Guy",
                company = "Google",
                location = "California",
                avatar = R.drawable.user3,
                repository = 9,
                username = "romainguy"
            ),
            UsersItem(
                follower = 14725,
                following = 1,
                name = "Chris Banes",
                company = "Google working on @android",
                location = "Sydney, Australia",
                avatar = R.drawable.user4,
                repository = 30,
                username = "chrisbanes"
            ),
            UsersItem(
                follower = 788,
                following = 0,
                name = "David",
                company = "Working Group Two",
                location = "Trondheim, Norway",
                avatar = R.drawable.user5,
                repository = 56,
                username = "tipsy"
            ),
            UsersItem(
                follower = 18628,
                following = 3,
                name = "Ravi Tamada",
                company = "Working Group Two",
                location = "India",
                avatar = R.drawable.user6,
                repository = 28,
                username = "ravi8x"
            ),
            UsersItem(
                follower = 277,
                following = 39,
                name = "Deny Prasetyo",
                company = "gojek-engineering",
                location = "Kotagede, Yogyakarta, Indonesia",
                avatar = R.drawable.user7,
                repository = 44,
                username = "jasoet"
            ),
            UsersItem(
                follower = 178,
                following = 23,
                name = "Budi Oktaviyan",
                company = "KotlinID",
                location = "Jakarta, Indonesia",
                avatar = R.drawable.user8,
                repository = 110,
                username = "budioktaviyan"
            ),
            UsersItem(
                follower = 428,
                following = 61,
                name = "Hendi Santika",
                company = "JVMDeveloperID @KotlinID @IDDevOps",
                location = "Bojongsoang - Bandung Jawa Barat",
                avatar = R.drawable.user9,
                repository = 1064,
                username = "hendisantika"
            ),
            UsersItem(
                follower = 428,
                following = 61,
                name = "Sidiq Permana",
                company = "Nusantara Beta Studio",
                location = "Jakarta Indonesia",
                avatar = R.drawable.user10,
                repository = 65,
                username = "sidiqpermana"
            )


        )
        val userAdapter = AdapterUser(listUser,object : AdapterUser.EventListener{
            override fun click(item: UsersItem) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_USER,item)
                }
                startActivity(intent)
            }

        })
        binding.rvUser.apply {
            adapter = userAdapter
        }

    }

}