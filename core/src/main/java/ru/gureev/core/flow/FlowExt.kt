package ru.gureev.core.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

fun flowInterval(
    delayMillis: Long,
    initialDelayMillis: Long = 0L
) = flow {
    require(delayMillis > 0) { "delayMillis must be positive" }
    require(initialDelayMillis >= 0) { "initialDelayMillis cannot be negative" }
    if (initialDelayMillis > 0) {
        delay(initialDelayMillis)
    }
    emit(System.currentTimeMillis())
    while (true) {
        delay(delayMillis)
        emit(System.currentTimeMillis())
    }
}.cancellable()

suspend fun <T> Flow<T>.firstOrDefault(default: T): T {
    return this.firstOrNull() ?: default
}
