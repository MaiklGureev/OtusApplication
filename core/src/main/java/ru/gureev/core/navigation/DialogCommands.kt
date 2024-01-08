package ru.gureev.core.navigation

import com.github.terrakok.cicerone.Command

data class ShowDialog(val screen: DialogScreen) : Command

data class CloseDialog(
    val clazz: Class<*>,
    val allowingStateLoss: Boolean = true
) : Command
