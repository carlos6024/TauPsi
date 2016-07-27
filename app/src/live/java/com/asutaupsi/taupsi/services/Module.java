package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;

public class Module {
    public static void register(TauPsiApplication application){
        new LiveBrotherService(application);
        new LiveInfoCardService(application);
        new LivePhotoService(application);
        new LiveRushService(application);
    }
}
