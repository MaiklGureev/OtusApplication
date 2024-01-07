package ru.gureev.otus_app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.gureev.otus_app.di.AppComponent
import ru.gureev.otus_app.di.DaggerAppComponent

class App : DaggerApplication() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(applicationContext).build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

}
