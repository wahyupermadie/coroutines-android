package com.godohdev.themoviedb.di

import android.app.Application
import com.godohdev.themoviedb.MainApplication
import com.godohdev.themoviedb.di.builder.ActivityBuilder
import com.godohdev.themoviedb.di.modul.AppModule
import com.godohdev.themoviedb.di.modul.DataModule
import com.godohdev.themoviedb.di.modul.NetworkModule
import com.godohdev.themoviedb.di.modul.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        DataModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun provideApplication(application: Application) : Builder
        fun provideNetworkModule(networkModule: NetworkModule) : Builder
        fun build() : AppComponent
    }

    fun inject(app: MainApplication)
}