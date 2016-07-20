package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;

public class BaseLiveService {
    protected  final Bus bus;
    protected final TauPsiApplication application;
    protected final DatabaseReference mDataBase;

    public BaseLiveService(TauPsiApplication application) {
        this.application = application;
        this.bus = application.getBus();
        mDataBase = FirebaseDatabase.getInstance().getReference();
        bus.register(this);
    }
}
