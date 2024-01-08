package ru.gureev.core.extensions

import java.math.BigDecimal

// https://stackoverflow.com/a/25542023
fun Double.toStringWithoutTrailingZeros(): String = BigDecimal(this.toString())
    .stripTrailingZeros()
    .toPlainString()

