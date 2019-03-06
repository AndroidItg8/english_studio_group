package com.ith8.esg.common;

import android.app.Application;

import com.ith8.testmvvm.R;


public class MyApplication extends Application {


    private static final String PREF_NAME = "MVVM_TEST";
    private static MyApplication mInstance;
    public boolean isLoggingNeeded;

    public static MyApplication getInstance() {
        return mInstance;
    }




    @Override
    public void onCreate() {
        super.onCreate();
        isLoggingNeeded=true;
        mInstance=this;
        mInstance.initPref();
        mInstance.initLog();

           initNetworkCall();

    }

    private void initPref() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(PREF_NAME)
                .setUseDefaultSharedPreference(false)
                .build();
    }

    private void initLog() {
        new Log.Builder().isLogEnable(true).build();
    }

    public RetroController initNetworkCall() {
        new NetworkCall.NetworkBuilder().setHeader().build();
        return NetworkCall.getController();
    }

    public String getAppToken() {
        return getString(R.string.app_token);
    }
}
