package org.sirekanyan.github

import android.app.Application
import android.content.Context

fun Context.app(): App =
    applicationContext as App

class App : Application() {
}
