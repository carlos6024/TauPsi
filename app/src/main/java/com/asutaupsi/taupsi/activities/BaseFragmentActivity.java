package com.asutaupsi.taupsi.activities;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public abstract class BaseFragmentActivity extends AppCompatActivity {
    protected TauPsiApplication application;
    protected Bus bus;


    protected abstract Fragment createFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        application = (TauPsiApplication) getApplication();
        bus = application.getBus();
        bus.register(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
