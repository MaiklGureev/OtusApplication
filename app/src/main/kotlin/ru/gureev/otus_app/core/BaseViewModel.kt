package ru.gureev.otus_app.core

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.gureev.otus_app.navigation.MainRouter
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var router: MainRouter

}
