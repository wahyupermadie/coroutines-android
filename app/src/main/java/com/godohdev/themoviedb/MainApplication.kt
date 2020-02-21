package com.godohdev.themoviedb

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.godohdev.themoviedb.di.AppComponent
import com.godohdev.themoviedb.di.DaggerAppComponent
import com.godohdev.themoviedb.di.modul.NetworkModule
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

class MainApplication : Application(), HasAndroidInjector{
    @Inject
    lateinit var androidDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidDispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .provideApplication(this)
            .provideNetworkModule(NetworkModule(this))
            .build()
    }
}