package org.sirekanyan.github.arch

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

interface Presenter {

    fun cancel()

}

abstract class BasePresenter<V : BaseView<*>> : Presenter, CoroutineScope {

    lateinit var view: V

    override val coroutineContext: CoroutineContext =
        SupervisorJob() + Dispatchers.Main + CoroutineExceptionHandler { _, throwable ->
            Log.e("Github", "Uncaught throwable", throwable)
        }

    override fun cancel() {
        coroutineContext.cancelChildren()
    }

}
