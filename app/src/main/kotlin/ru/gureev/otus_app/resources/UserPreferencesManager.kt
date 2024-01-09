package ru.gureev.otus_app.resources

import android.content.SharedPreferences
import ru.gureev.core.resources.IUserPreferencesManager
import javax.inject.Inject

class UserPreferencesManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IUserPreferencesManager {

    override var exampleValue: String
        get() = sharedPreferences.getString(EXAMPLE_KEY, "").orEmpty()
        set(value) {
            sharedPreferences.edit().putString(EXAMPLE_KEY, value).apply()
        }

    override fun clearPrefs() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        private const val EXAMPLE_KEY = "EXAMPLE_KEY"
    }

}
