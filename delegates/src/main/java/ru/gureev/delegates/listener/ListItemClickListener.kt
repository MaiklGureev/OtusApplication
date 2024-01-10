package ru.gureev.delegates.listener

import ru.gureev.delegates.ListViewModel

fun interface ListItemClickListener {
    fun onListItemClicked(delegateViewModel: ListViewModel)
}
