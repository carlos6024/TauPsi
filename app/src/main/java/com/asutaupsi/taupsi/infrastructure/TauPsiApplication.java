package com.asutaupsi.taupsi.infrastructure;

import android.app.Application;

import com.asutaupsi.taupsi.services.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

public class TauPsiApplication extends Application {
    private Bus bus;


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
