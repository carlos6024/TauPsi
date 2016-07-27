package com.asutaupsi.taupsi.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.asutaupsi.taupsi.fragments.AboutFragment;
import com.asutaupsi.taupsi.fragments.MeetABrotherFragment;
import com.asutaupsi.taupsi.fragments.RushFragment;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public class PracticeActiviy extends BaseActivity {
    protected TauPsiApplication application;
    protected Bus bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = RushFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }

}


