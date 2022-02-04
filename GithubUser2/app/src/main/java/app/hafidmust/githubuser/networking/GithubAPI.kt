package app.hafidmust.githubuser.networking

import app.hafidmust.githubuser.data.api.DetailResponse
import app.hafidmust.githubuser.data.api.FollowResponseItem
import app.hafidmust.githubuser.data.api.SearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubAPI {
//    get username
    @GET("search/users")
    @Headers("Authorization: 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")
    suspend fun getSearch(
        @Query("q")username : String
    ) : Response<SearchResponse>

    @GET("users/{username}")
    suspend fun getDetail(
        @Path("username") username: String
    ) : Response<DetailResponse>

    @GET("users/{username}/followers")
    suspend fun getDetailFollower(
        @Path("username") username: String
    ) : Response<List<FollowResponseItem>>

    @GET("users/{username}/following")
    suspend fun getDetailFollowing(
        @Path("username") username: String
    ) : Response<List<FollowResponseItem>>


    companion object {
        fun getInstance() : Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
        }
    }
}