package ru.gureev.otus_app.navigation

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gureev.otus_app.R

open class AnimatedNavigator(
    activity: FragmentActivity,
    containerId: Int,
) : AppNavigator(activity, containerId) {
    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        fragmentTransaction.setCustomAnimations(
            R.anim.card_slide_left_in,
            R.anim.card_slide_left_out,
            R.anim.card_slide_right_in,
            R.anim.card_slide_right_out
        )
    }

    override fun applyCommand(command: Command) {
        when (command) {
            is CloseDialog -> closeDialog(command)
            is ShowDialog -> showDialog(command)
            else -> super.applyCommand(command)
        }
    }

    protected open fun showDialog(command: ShowDialog) {
        val tag = command.screen.screenKey
        val dialog = command.screen.createDialog(fragmentFactory)
        dialog.show(fragmentManager, tag)
    }

    protected open fun closeDialog(command: CloseDialog) {
        val tag = command.clazz.name
        val dialog = fragmentManager.findFragmentByTag(tag)
        if (dialog is DialogFragment) {
            dialog.dismiss()
        }
    }
}
