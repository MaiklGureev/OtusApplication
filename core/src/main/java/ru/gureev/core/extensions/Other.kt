package ru.gureev.core.extensions

import android.view.View
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

private const val ONE = 1

fun String?.toIntOrZero() = this?.toIntOrNull().orZero()
fun Int?.atLeastOne() = this.orZero().coerceAtLeast(ONE)
fun String?.toFloatOrZero() = this.orEmpty().toFloatOrNull() ?: 0f
fun Int?.orZero() = this ?: 0
fun Double?.orZero() = this ?: 0
fun Boolean?.orFalse() = this ?: false
fun Boolean?.orTrue() = this ?: true
fun Boolean.takeIfTrue() = this.takeIf { it }
fun Boolean.takeIfFalse() = this.takeIf { !it }

fun <T> T?.orIfNull(onNull: () -> T) = this ?: onNull.invoke()
fun <T> T?.orIfNullOrEmpty(onNull: () -> T): T {
    return if (this == null || this == "") {
        onNull()
    } else this
}

fun <T, V> V?.orLet(value: T?, onLet: (T) -> V) = this ?: value?.let(onLet)


fun <T : Any> unsafeLazy(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)


fun String?.replaceAllFirstZeroes(oldValue: String = "^0+(?!$)", newValue: String = ""): String {
    return this?.replaceFirst(oldValue.toRegex(), newValue).orEmpty()
}

fun <T : Any> List<T>?.orMutableEmpty() = (this ?: emptyList()).toMutableList()

fun <T : Any> List<T>.onlyOneElement() = size == 1

fun Long?.orZero() = this ?: 0L

infix fun List<*>.same(other: List<*>): Boolean {
    val isSameSize = this.size == other.size
    return isSameSize && this.containsAll(other)
}

infix fun List<*>.notSame(other: List<*>): Boolean {
    val isSame = (this same other)
    return !isSame
}

fun <T : Any> tryOrNull(tryFunc: () -> T): T? {
    return try {
        tryFunc()
    } catch (e: Exception) {
        null
    }
}

fun LocalDateTime.toJavaDate(): Date {
    return Date.from(atZone(ZoneId.systemDefault()).toInstant())
}

fun Date.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(toInstant(), ZoneId.systemDefault())
}

fun Long.toHHmmSS(): String {
    val timeFormat = "%02d:%02d:%02d"
    val millisInMinute: Long = 60000
    val millisInHour: Long = 3600000

    val timeMillis = this
    val seconds = (timeMillis / 1000).toInt() % 60
    val minutes = (timeMillis / millisInMinute % 60).toInt()
    val hours = (timeMillis / millisInHour).toInt()

    return String.format(timeFormat, hours, minutes, seconds)
}

fun LocalDateTime.withoutNs(): LocalDateTime {
    return withNano(0)
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}
