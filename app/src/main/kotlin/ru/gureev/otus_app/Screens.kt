package ru.gureev.otus_app

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gureev.otus_app.feature_1.Feature1Fragment
import ru.gureev.otus_app.feature_0.Feature0Fragment

object Screens {

    fun  Feature1Screen(): FragmentScreen= FragmentScreen {
        Feature1Fragment.newInstance()
    }

    fun  Feature0Screen(): FragmentScreen = FragmentScreen {
        Feature0Fragment.newInstance()
    }
}

