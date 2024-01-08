package ru.gureev.core

import androidx.lifecycle.ViewModel
import ru.gureev.core.navigation.MainRouter
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var router: MainRouter

}
