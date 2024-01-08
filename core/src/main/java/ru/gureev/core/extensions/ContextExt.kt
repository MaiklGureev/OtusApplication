package ru.gureev.core.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.text.format.Formatter
import androidx.core.app.NotificationCompat

@SuppressLint("MissingPermission")
fun Context.isInternetConnected(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.getNetworkCapabilities(manager.activeNetwork)?.run {
        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
        hasTransport(NetworkCapabilities.TRANSPORT_VPN)
    }.orFalse()
}

inline fun <reified T> Context.systemService(): T? = getSystemService(T::class.java)

fun Context.createNotificationBuilder(): NotificationCompat.Builder {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationCompat.Builder(this, "lenta_notification")
    } else {
        NotificationCompat.Builder(this)
    }
}

fun Context.openAppSystemSettings() {
    startActivity(Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = Uri.fromParts("package", packageName, null)
    })
}

val Context.wifiDeviceIp: String
    get() {
        val wifiManager = this.getSystemService(WifiManager::class.java)
        return Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
    }


