package com.muf.daggertemplate.ui

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SaveNameViewModel @Inject constructor(val sharedPreferences: SharedPreferences, val editor: SharedPreferences.Editor): ViewModel(){
    val mSavedNameData = MutableLiveData<String>()

    fun getSavedName(){
        mSavedNameData.postValue(sharedPreferences.getString("Name", ""))
    }

    fun saveName(name: String){

        editor.putString("Name", name).apply()
    }
}