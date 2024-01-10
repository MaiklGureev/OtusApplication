package ru.gureev.core.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object FileSharingError : Failure()
    object NetworkConnection : Failure()
    object SocketConnectError : Failure()
    object TimeOutError : Failure()
    object WeighingError : Failure()
    object ServerError : Failure()
    object AuthError : Failure()
    object InvalidProductForTask : Failure()
    object NotValidEnterNumber : Failure()
    object FileReadingError : Failure()
    object PrintTemplateError : Failure()

    data class ThrowableFailure(val e: Throwable) : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

    /** Internal app Message failure **/
    data class MessageFailure(val message: String? = null, val messageResId: Int? = null) : Failure()

    /** UseCase processing result  **/
    data class UseCaseResultFailure(val result: IUseCaseResultFailure) : Failure()
}

interface IUseCaseResultFailure
