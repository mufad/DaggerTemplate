package com.muf.daggertemplate.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muf.daggertemplate.ui.SaveNameViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [DaggerViewModelFactory].
 */
@Module
abstract class ViewModelModule {



    @Binds
    @IntoMap
    @ViewModelKey(SaveNameViewModel::class)
    abstract fun bindSaveNameViewModel(saveNameViewModel : SaveNameViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

}