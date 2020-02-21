package com.godohdev.themoviedb.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.godohdev.themoviedb.utils.extentions.showSnackbar
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    abstract fun setupLayoutId() : Int
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(setupLayoutId())
        onActivityReady(savedInstanceState)
        if (isUsingViewModel()){
            setupObserver(getViewModel()!!)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    abstract fun getViewModel() : BaseViewModel?

    abstract fun onActivityReady(savedInstanceState: Bundle?)

    private fun setupObserver(baseViewModel: BaseViewModel) {
        baseViewModel.errorHandler.observe(this, Observer {
            it.getContentIfNotHandled()?.let {message ->
                showSnackbar(message, Snackbar.LENGTH_LONG)
            }
        })

        baseViewModel.loadingHandler.observe(this, Observer {
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

    abstract fun isUsingViewModel() : Boolean
}