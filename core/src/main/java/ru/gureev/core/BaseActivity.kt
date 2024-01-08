package ru.gureev.core

import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.android.support.DaggerAppCompatActivity
import ru.gureev.core.navigation.AnimatedNavigator
import ru.gureev.core.navigation.MainRouter
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var router: MainRouter

    val navigator: Navigator = AnimatedNavigator(this, R.id.fragment_container)

    @Inject
    open lateinit var navigatorHolder: NavigatorHolder

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
