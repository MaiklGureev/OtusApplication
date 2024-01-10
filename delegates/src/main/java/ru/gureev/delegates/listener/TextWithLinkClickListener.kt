package ru.gureev.delegates.listener

interface TextWithLinkClickListener {

    fun onLinkClicked(url: String)

    fun onPhoneClicked(phone: String)

    fun linkClickEventLoggingAction(url: String, notificationTitle: String) = Unit
}
