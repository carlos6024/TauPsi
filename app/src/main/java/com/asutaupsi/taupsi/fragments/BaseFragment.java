package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public abstract class BaseFragment extends Fragment {
    protected TauPsiApplication application;
    protected Bus bus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (TauPsiApplication) getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
