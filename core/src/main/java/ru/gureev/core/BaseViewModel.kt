package ru.gureev.core

import androidx.lifecycle.ViewModel
import ru.gureev.core.exception.Failure
import ru.gureev.core.navigation.MainRouter
import ru.gureev.core.view_model.SingleLiveEvent
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var router: MainRouter

    val failure = SingleLiveEvent<Failure>()
    var isFirstInitialized = false

    open fun handleFailure(failure: Failure) {
        //Logg.e { "handleFailure: $failure" }
        this.failure.postValue(failure)
    }

    open fun handleFailure(failure: Failure.UseCaseResultFailure) {
        //Logg.e { "handleFailureUseCase: ${failure.result}" }
        this.failure.postValue(failure)
    }

    open suspend fun handleFailureSuspend(failure: Failure.UseCaseResultFailure) {
        //Logg.e { "handleFailureUseCaseSuspend: ${failure.result}" }
        this.failure.postValue(failure)
    }

}
