package org.sirekanyan.github.data.model

import com.google.gson.annotations.SerializedName

class GithubRepo(
    val id: Long,
    val name: String,
    val description: String,
    @SerializedName("stargazers_count")
    val stars: Long,
    @SerializedName("forks_count")
    val forks: Long,
    val language: String,
    @SerializedName("html_url")
    val url: String,
)
