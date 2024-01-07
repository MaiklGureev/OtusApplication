package ru.gureev.otus_app.di.android

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gureev.otus_app.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [FragmentModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}
