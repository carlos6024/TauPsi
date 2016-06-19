package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected TauPsiApplication application;
    protected Bus bus;
    private Boolean isRegisteredwithBus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (TauPsiApplication) getApplication();
        bus = application.getBus();
        bus.register(this);
        isRegisteredwithBus = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isRegisteredwithBus) {
            bus.unregister(this);
            isRegisteredwithBus = false;
        }
    }





}
