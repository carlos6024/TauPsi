package com.asutaupsi.taupsi.infrastructure;

import android.app.Application;

import com.asutaupsi.taupsi.services.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

public class TauPsiApplication extends Application {
    private Bus bus;

    public static final String BROTHER_FIREBASE_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/brothers";
    public static final String YOUTUBE_API_KEY = "";



    public TauPsiApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        Module.register(this);
    }


    public Bus getBus() {
        return bus;
    }


}
