package ru.gureev.otus_app.core

import androidx.annotation.StringRes

interface IBaseView {

    fun showSnackbar(@StringRes message: Int)

    fun showSnackbar(message: String)

    fun showToast(message: String)
}
