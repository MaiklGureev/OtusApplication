package ru.gureev.otus_app.di.android

import com.example.feature_1.Feature1Fragment
import com.example.feature_1.di.Feature1ViewModelsModule
import com.example.feature_2.Feature2Fragment
import com.example.feature_2.di.Feature2ViewModelsModule
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.gureev.api.Feature0Screen
import ru.gureev.api.Feature1Screen
import ru.gureev.api.Feature2Screen
import ru.gureev.feature_0.Feature0Fragment
import ru.gureev.feature_0.di.Feature0ViewModelsModule

@Module(includes = [FragmentModule.DataBinds::class])
class FragmentModule {
    @Provides
    fun provideFeature0Screen(): Feature0Screen = object : Feature0Screen {
        override fun createFeature0Screen(): FragmentScreen {
            return FragmentScreen {
                Feature0Fragment.newInstance()
            }
        }
    }

    @Provides
    fun provideFeature1Screen(): Feature1Screen = object : Feature1Screen {
        override fun createFeature1Screen(): FragmentScreen {
            return FragmentScreen {
                Feature1Fragment.newInstance()
            }
        }
    }

    @Provides
    fun provideFeature2Screen(): Feature2Screen = object : Feature2Screen {
        override fun createFeature2Screen(category: String): FragmentScreen {
            return FragmentScreen {
                Feature2Fragment.newInstance(category)
            }
        }
    }

    @Module
    interface DataBinds {
        @ContributesAndroidInjector(
            modules = [
                Feature0ViewModelsModule::class,
            ]
        )
        fun contributeFeature0Fragment(): Feature0Fragment

        @ContributesAndroidInjector(
            modules = [
                Feature1ViewModelsModule::class,
            ]
        )
        fun contributeFeature1Fragment(): Feature1Fragment

        @ContributesAndroidInjector(
            modules = [
                Feature2ViewModelsModule::class,
            ]
        )
        fun contributeFeature2Fragment(): Feature2Fragment
    }
}

