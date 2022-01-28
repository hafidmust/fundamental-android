package app.hafidmust.githubuser

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class UsersItem(

    @field:SerializedName("follower")
    val follower: Int,

    @field:SerializedName("following")
    val following: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("company")
    val company: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("avatar")
    val avatar: Int,

    @field:SerializedName("repository")
    val repository: Int,

    @field:SerializedName("username")
    val username: String
) : Parcelable
