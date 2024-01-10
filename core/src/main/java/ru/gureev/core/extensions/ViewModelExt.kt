package ru.gureev.core.extensions

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.gureev.core.BaseViewModel
import ru.gureev.core.exception.Failure

fun BaseViewModel.launchUITryCatch(
    delayTime: Long = 0,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    catchBlock: ((Throwable) -> Unit)? = null, tryBlock: suspend CoroutineScope.() -> Unit
) {
    try {
        viewModelScope.launch(viewModelScope.coroutineContext, start) {
            val delayedTime = if (!isFirstInitialized) {
                isFirstInitialized = true
                100L
            } else {
                delayTime
            }
            if (delayedTime > 0) {
                delay(delayedTime)
            }
            tryBlock()
        }
    } catch (e: Throwable) {
        catchBlock?.invoke(e) ?: handleFailure(failure = Failure.ThrowableFailure(e))
    }
}

fun BaseViewModel.launchAsyncTryCatch(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    catchBlock: ((Throwable) -> Unit)? = null,
    tryBlock: suspend CoroutineScope.() -> Unit
) {
    try {
        launchAsync(dispatcher, start, tryBlock)
    } catch (e: Throwable) {
        catchBlock?.invoke(e) ?: handleFailure(failure = Failure.ThrowableFailure(e))
    }
}

fun BaseViewModel.launchAsync(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(viewModelScope.coroutineContext + dispatcher, start, block)
}
