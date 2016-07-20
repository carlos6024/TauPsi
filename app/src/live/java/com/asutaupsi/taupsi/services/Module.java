package com.asutaupsi.taupsi.services;

import android.util.Log;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;

public class Module {
    private static final String TAG = Module.class.getSimpleName();
    public static void register(TauPsiApplication application){
        Log.i(TAG,"LIVE REGISTER METHOD CALLED");
        new LiveBrotherService(application);
    }
}
