package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected TauPsiApplication application;
    protected Bus bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (TauPsiApplication) getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
