package com.muf.daggertemplate

import android.app.Application
import com.muf.daggertemplate.di.components.AppComponent
import com.muf.daggertemplate.di.components.DaggerAppComponent
import com.muf.daggertemplate.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    companion object {
        lateinit var appComponents: AppComponent
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        appComponents = initDagger(this)


    }


    private fun initDagger(app: App): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

}