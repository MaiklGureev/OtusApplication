package ru.gureev.core.extensions

import android.text.StaticLayout

fun Int.countDigits() = toString().countDigits()

fun CharSequence.countDigits(): Int = count { it.isDigit() }

fun String.takeLastLine(textLayout: StaticLayout, maxLines: Int): String = substring(
    textLayout.getLineStart(maxLines - 1),
    textLayout.getLineEnd(maxLines - 1)
)

fun String.isSapTrue(): Boolean = this.equals("X", true)
fun String.isSapFalse(): Boolean = this.equals("", true)

fun emptyString() = ""
