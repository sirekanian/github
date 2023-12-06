package org.sirekanyan.github.data.model

import com.google.gson.annotations.SerializedName

class GithubReposResponse(@SerializedName("items") val repos: List<GithubRepo>)
