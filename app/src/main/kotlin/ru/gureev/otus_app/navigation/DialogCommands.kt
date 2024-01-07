package ru.gureev.otus_app.navigation

import com.github.terrakok.cicerone.Command
import com.lenta.mark_checker.navigation.DialogScreen

data class ShowDialog(val screen: DialogScreen) : Command

data class CloseDialog(
    val clazz: Class<*>,
    val allowingStateLoss: Boolean = true
) : Command
