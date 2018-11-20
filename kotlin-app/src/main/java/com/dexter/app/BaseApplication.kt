package com.dexter.app

import android.app.Application

import com.dexter.utils.BuildConfig
import net.gotev.uploadservice.UploadService

import timber.log.Timber

/**
 * An application class
 */
class BaseApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        //initialising Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        UploadService.NAMESPACE = BuildConfig.APPLICATION_ID;
    }

    companion object {
        lateinit var instance: BaseApplication
    }
}
