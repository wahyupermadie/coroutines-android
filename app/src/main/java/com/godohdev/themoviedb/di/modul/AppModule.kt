package com.godohdev.themoviedb.di.modul

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application) : Context = application.applicationContext

}