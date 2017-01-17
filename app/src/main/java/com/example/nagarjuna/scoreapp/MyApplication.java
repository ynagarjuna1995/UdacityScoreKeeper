package com.example.nagarjuna.scoreapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Nagarjuna on 15-01-2017.
 */

public class MyApplication extends Application {

    private static MyApplication _instance;
    public RefWatcher _refWatcher;

    public static MyApplication getInstance(){
        return _instance;
    }

    public static RefWatcher get_refWatcher(){
        return MyApplication.getInstance()._refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = (MyApplication) getApplicationContext();
        _refWatcher = LeakCanary.install(this);
    }
}
