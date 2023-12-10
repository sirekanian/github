package org.sirekanyan.github.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition
import com.bumptech.glide.request.transition.TransitionFactory
import org.sirekanyan.github.R

private val crossFadeTransitionFactory = TransitionFactory { _, _ ->
    DrawableCrossFadeTransition(300, true)
}

private fun ImageView.setImage(
    url: String?,
    requestOptions: RequestOptions,
    @DrawableRes placeholderRes: Int,
) {
    val placeholder = ContextCompat.getDrawable(context, placeholderRes)
    Glide.with(context)
        .load(url)
        .apply(requestOptions.placeholder(placeholder))
        .transition(DrawableTransitionOptions.with(crossFadeTransitionFactory))
        .into(this)
}

fun ImageView.setCircleImage(url: String?) {
    setImage(url, RequestOptions.circleCropTransform(), R.drawable.gh_oval_placeholder)
}
