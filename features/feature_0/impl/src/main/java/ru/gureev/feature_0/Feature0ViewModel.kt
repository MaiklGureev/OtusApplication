package ru.gureev.feature_0

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.MutableLiveData
import ru.gureev.api.Feature1Screen
import ru.gureev.core.BaseViewModel
import ru.gureev.core.extensions.doOnMain
import ru.gureev.core.extensions.launchAsyncTryCatch
import ru.gureev.core.resources.IStringResources
import ru.gureev.domain.ILoadAndSaveMarketNewsUseCase
import ru.gureev.models.NewsCategory
import javax.inject.Inject


class Feature0ViewModel @Inject constructor(
    private val loadAndSaveMarketNewsUseCase: ILoadAndSaveMarketNewsUseCase,
    private val feature1Screen: Feature1Screen,
    private val stringResources: IStringResources,
    private val connectivityManager: ConnectivityManager,
) : BaseViewModel() {

    val counterText = MutableLiveData("")

    fun loadData() {
        if (isNetworkAvailable()) {
            launchAsyncTryCatch {
                val categoryList = listOf(
                    NewsCategory.GENERAL.value,
                    NewsCategory.CRYPTO.value,
                    NewsCategory.FOREX.value,
                    NewsCategory.MERGER.value,
                )
                val loadingTemplate = stringResources.loading
                loadAndSaveMarketNewsUseCase.invoke(categoryList) { currentIndex ->
                    doOnMain {
                        counterText.value = loadingTemplate.format(currentIndex, categoryList.size)
                    }
                }
                router.newRootScreen(feature1Screen.createFeature1Screen())
            }
        } else {
            router.newRootScreen(feature1Screen.createFeature1Screen())
        }

    }

    @SuppressLint("MissingPermission")
    private fun isNetworkAvailable(): Boolean {
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw)
        return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(
            NetworkCapabilities.TRANSPORT_CELLULAR
        ) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) || actNw.hasTransport(
            NetworkCapabilities.TRANSPORT_BLUETOOTH
        ))

    }
}
