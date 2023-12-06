package org.sirekanyan.github.data

import org.sirekanyan.github.data.model.GithubReposResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories?q=stars:>=1000&sort=stars")
    suspend fun getGithubRepos(@Query("page") page: Int): GithubReposResponse

}
