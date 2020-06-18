package com.amit.sampleapp

import android.content.Context
import androidx.multidex.MultiDexApplication

class SampleApp :MultiDexApplication(){

    companion object {
    private  var appContext: Context? = null

    fun setAppContext(context: Context?) {
        appContext = context
    }

    fun getAppContext(): Context? {
        return appContext
    }
}

    override fun onCreate() {
        super.onCreate()
    }
}