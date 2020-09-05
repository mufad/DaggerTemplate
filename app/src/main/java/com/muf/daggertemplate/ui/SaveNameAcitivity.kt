package com.muf.daggertemplate.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muf.daggertemplate.App
import com.muf.daggertemplate.R
import kotlinx.android.synthetic.main.activity_save_name.*
import javax.inject.Inject

class SaveNameAcitivity : AppCompatActivity() {

    private val  appComponent by lazy { App.appComponents }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var savedNameViewModel : SaveNameViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVars()
        loadViewModelData()


        btn_save.setOnClickListener {
            //Call Viewmodels SaveDataMethod
            savedNameViewModel?.saveName(et_name.text.toString())
        }
    }

    private fun initVars() {
        appComponent.inject(this)
        setContentView(R.layout.activity_save_name)
        savedNameViewModel = ViewModelProvider(this, viewModelFactory).get(SaveNameViewModel::class.java)
        savedNameViewModel?.getSavedName()
    }

    private fun loadViewModelData(){
        savedNameViewModel?.mSavedNameData?.observe(this, Observer {
            tv_name.text = it.toString()
        })
    }
}