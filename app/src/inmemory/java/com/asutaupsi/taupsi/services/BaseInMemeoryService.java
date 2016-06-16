package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public class BaseInMemeoryService {
    protected final Bus bus;
    protected final TauPsiApplication application;


    public BaseInMemeoryService(TauPsiApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }
}
