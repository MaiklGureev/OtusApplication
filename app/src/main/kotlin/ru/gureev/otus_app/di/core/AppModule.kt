package ru.gureev.otus_app.di.core

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.gureev.core.resources.IColorResources
import ru.gureev.core.resources.IDrawableResources
import ru.gureev.core.resources.IStringResources
import ru.gureev.core.resources.IUserPreferencesManager
import ru.gureev.otus_app.resources.StringResources
import ru.gureev.otus_app.resources.UserPreferencesManager
import ru.gureev.otus_app.utils.Constants.SHARED_PREFERENCES_NAME


@Module(includes = [AppModule.DataBinds::class])
class AppModule {

    @Provides
    fun providePrefs(context: Context): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            /* fileName = */ SHARED_PREFERENCES_NAME,
            /* masterKeyAlias = */ masterKeyAlias,
            /* context = */ context,
            /* prefKeyEncryptionScheme = */ EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            /* prefValueEncryptionScheme = */ EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Module
    interface DataBinds {

        @Binds
        fun bindsStringResources(value: StringResources): IStringResources

        @Binds
        fun bindsDrawableResources(value: IDrawableResources): IDrawableResources

        @Binds
        fun bindsColorResources(value: IColorResources): IColorResources

        @Binds
        fun bindsUserPreferencesManager(value: UserPreferencesManager): IUserPreferencesManager

    }
}
