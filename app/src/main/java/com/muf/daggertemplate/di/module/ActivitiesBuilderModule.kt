package com.muf.daggertemplate.di.module


import android.content.Context
import com.muf.daggertemplate.ui.SaveNameAcitivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * To hold activities to support AndroidInjection call from dagger.
 */
@Module
abstract class ActivitiesBuilderModule {

    @ContributesAndroidInjector
    abstract fun saveNameActivity(): SaveNameAcitivity

}