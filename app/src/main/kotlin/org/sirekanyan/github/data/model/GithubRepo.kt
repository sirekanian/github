package org.sirekanyan.github.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubRepo(
    val id: Long,
    val name: String,
    val description: String,
    @SerializedName("stargazers_count")
    val stars: Long,
    @SerializedName("forks_count")
    val forks: Long,
    val language: String?,
    @SerializedName("html_url")
    val url: String,
) : Parcelable {

    fun formattedStars(): String =
        formatNumber(stars)

    fun formattedForks(): String =
        formatNumber(forks)

    private fun formatNumber(number: Long): String =
        if (number < 1000) "$number" else "${(number / 1000)}k"

}
