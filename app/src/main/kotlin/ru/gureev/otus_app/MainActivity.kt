package ru.gureev.otus_app

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import ru.gureev.api.Feature0Screen
import ru.gureev.core.BaseActivity
import ru.gureev.core.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var feature0Screen: Feature0Screen

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.binding = binding
        if (savedInstanceState == null) {
            router.newRootScreen(feature0Screen.createFeature0Screen())
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}
