package com.dexter.app;

import android.app.Application;

import com.dexter.utils.BuildConfig;

import net.gotev.uploadservice.UploadService;

import timber.log.Timber;

/**
 * An application class
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    public BaseApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //initialising Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        UploadService.NAMESPACE = BuildConfig.APPLICATION_ID;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
