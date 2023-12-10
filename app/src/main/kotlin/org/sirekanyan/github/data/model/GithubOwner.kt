package org.sirekanyan.github.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubOwner(
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
) : Parcelable
