package ru.gureev.otus_app.core

import android.os.Bundle
import android.os.PersistableBundle
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.android.support.DaggerAppCompatActivity
import ru.gureev.otus_app.App
import ru.gureev.otus_app.R
import ru.gureev.otus_app.navigation.AnimatedNavigator
import ru.gureev.otus_app.navigation.MainRouter
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var router: MainRouter

    val navigator: Navigator = AnimatedNavigator(this, R.id.fragment_container)

    @Inject
    open lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
