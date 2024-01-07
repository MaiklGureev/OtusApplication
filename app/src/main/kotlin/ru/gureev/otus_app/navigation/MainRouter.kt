package ru.gureev.otus_app.navigation

import com.github.terrakok.cicerone.Router
import com.lenta.mark_checker.navigation.DialogScreen

class MainRouter : Router() {
    fun showDialog(screen: DialogScreen) = executeCommands(ShowDialog(screen))
    fun closeDialog(clazz: Class<*>) = executeCommands(CloseDialog(clazz))
}
