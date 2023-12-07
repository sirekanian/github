package org.sirekanyan.github.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.setMain

abstract class BaseTest {

    protected val testScope: TestScope

    init {
        val testScheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(testScheduler)
        testScope = TestScope(testDispatcher)
        @OptIn(ExperimentalCoroutinesApi::class)
        Dispatchers.setMain(testDispatcher)
    }

    protected fun TestScope.moveUntilIdle() {
        @OptIn(ExperimentalCoroutinesApi::class)
        advanceUntilIdle()
    }

}
