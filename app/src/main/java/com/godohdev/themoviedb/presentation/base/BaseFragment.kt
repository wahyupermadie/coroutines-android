package com.godohdev.themoviedb.presentation.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.godohdev.themoviedb.di.viewmodel.ViewModelFactory
import com.godohdev.themoviedb.utils.extentions.showSnackbar
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

abstract class BaseFragment<T> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    abstract fun getViewModel() : T

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObserver((getViewModel() as BaseViewModel))
    }

    private fun setupObserver(baseViewModel: BaseViewModel) {

        baseViewModel.errorHandler.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {message ->
                showSnackbar(message, Snackbar.LENGTH_LONG)
            }
        })

        baseViewModel.loadingHandler.observe(viewLifecycleOwner, Observer {
            if(it){
                showLoading()
            }else{
                hideLoading()
            }
        })
    }

    protected open fun hideLoading(){

    }

    protected open fun showLoading(){

    }
}