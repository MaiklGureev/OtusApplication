package ru.gureev.otus_app

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.github.terrakok.cicerone.NavigatorHolder
import ru.gureev.otus_app.core.BaseActivity
import ru.gureev.otus_app.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    val featureMediator: () -> Unit = {
        router.newRootScreen(Screens.Feature0Screen())
//        FeatureMediator.startSplashScreenFeature(
//            (application as App).appComponent as AppDeps
//        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.binding = binding
        if (savedInstanceState == null) {
            println("Screens.SplashScreen")
            featureMediator.invoke()
//            router.newRootScreen(Screens.SplashScreen)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}
