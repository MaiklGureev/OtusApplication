package ru.gureev.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment
import ru.gureev.core.extensions.makeGone
import ru.gureev.core.extensions.makeVisible
import javax.inject.Inject

abstract class BaseFragment<Binding : ViewBinding, VM : BaseViewModel>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> Binding,
    private val clazz: Class<VM>
) : DaggerFragment() {


    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM
    open var binding: Binding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateViewModel()
    }

    fun updateViewModel(): Unit {
        viewModel = ViewModelProvider(this, providerFactory)[clazz]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = bindingInflater(inflater, container, false)
        return binding?.root
    }

    fun showLoader(): Unit {
        (binding?.root as View).findViewById<View>(R.id.progress).makeVisible()
    }

    fun closeLoader(): Unit {
        (binding?.root as View).findViewById<View>(R.id.progress).makeGone()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
