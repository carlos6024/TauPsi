package com.asutaupsi.taupsi.services;

import android.util.Log;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;

public class Module {

    private static final String LOG_TAG = Module.class.getSimpleName();

    public static void register(TauPsiApplication application){
        Log.i(LOG_TAG,"IN MEMORY REGISTER METHOD CALLED");
        new InMemoryBrotherService(application);
        new InMemoryRushService(application);
        new InMemoryInformationCardServices(application);
        new InMemoryPhotoService(application);
    }
}
