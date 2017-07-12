package com.imeepwni.android.criminalintent.app

import android.app.*

/**
 * Create by guofeng on 2017/7/12.
 */
class App : Application() {

    companion object {
        private lateinit var instance: Application
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}