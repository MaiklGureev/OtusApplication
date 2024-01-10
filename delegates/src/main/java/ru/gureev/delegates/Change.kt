package ru.gureev.delegates

data class Change<out T>(
    val oldData: T,
    val newData: T
) {

    companion object {

        fun <T> createCombinedPayload(payloads: List<Change<T>>): Change<T> {
            assert(payloads.isNotEmpty())
            val firstChange = payloads.first()
            val lastChange = payloads.last()

            return Change(firstChange.oldData, lastChange.newData)
        }

    }

}
