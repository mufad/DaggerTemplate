package com.muf.daggertemplate.di.components

import com.muf.daggertemplate.App
import com.muf.daggertemplate.di.module.AppModule
import com.muf.daggertemplate.ui.SaveNameAcitivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    // inject the above given modules into this App class
    fun inject(app: App)

    fun inject(saveNameAcitivity: SaveNameAcitivity)
}