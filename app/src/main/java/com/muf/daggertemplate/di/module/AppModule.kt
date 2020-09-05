package com.muf.daggertemplate.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.muf.daggertemplate.di.viewmodels.ViewModelModule
import com.muf.daggertemplate.utls.Constants

import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
    ActivitiesBuilderModule::class
    ]
)
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application {
        return this.application
    }

    @Singleton
    @Provides
    fun provideSharedPrefEditor(application: Application): SharedPreferences.Editor {
        return application.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE).edit()
    }


    @Singleton
    @Provides
    fun provideSharedPref(application: Application): SharedPreferences {
        return application.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
    }
}