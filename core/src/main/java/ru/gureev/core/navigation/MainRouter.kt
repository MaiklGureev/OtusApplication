package ru.gureev.core.navigation

import com.github.terrakok.cicerone.Router

class MainRouter : Router() {
    fun showDialog(screen: DialogScreen) = executeCommands(ShowDialog(screen))
    fun closeDialog(clazz: Class<*>) = executeCommands(CloseDialog(clazz))
}
