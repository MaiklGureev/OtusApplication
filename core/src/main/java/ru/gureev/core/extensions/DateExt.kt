package ru.gureev.core.extensions

import ru.gureev.core.common.Constants.EMPTY_DATE
import ru.gureev.core.common.Constants.EMPTY_STRING
import ru.gureev.core.common.DateFormats
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(format: String): String {
    val sdf = SimpleDateFormat(format, Locale("ru"))
    return runCatching {
        sdf.format(this)
    }.getOrDefault("")
}

fun formatDate(
    date: String,
    inPattern: String = DateFormats.DATA_FORMAT_IN,
    outPattern: String = DateFormats.DATA_FORMAT_OUT
): String {
    var formattedDate = ""
    val sdf = SimpleDateFormat(inPattern, Locale("RU"))
    val sdf2 = SimpleDateFormat(outPattern, Locale("RU"))
    try {
        formattedDate = sdf2.format(sdf.parse(date) ?: Date()).takeIf { date != EMPTY_DATE }
            .orIfNull { EMPTY_STRING }
    } catch (e: ParseException) {
        formattedDate = EMPTY_STRING
    }
    return formattedDate
}
