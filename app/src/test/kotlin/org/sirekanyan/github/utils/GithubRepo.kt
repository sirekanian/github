package org.sirekanyan.github.utils

import org.sirekanyan.github.data.model.GithubOwner
import org.sirekanyan.github.data.model.GithubRepo

fun createGithubRepo(): GithubRepo =
    GithubRepo(0, "name", "description", 0, 0, "language", "url", createGithubOwner())

fun createGithubOwner(): GithubOwner =
    GithubOwner("login", avatarUrl = null)
