package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryPhotoService extends BaseInMemeoryService {
    public InMemoryPhotoService(TauPsiApplication application) {
        super(application);
    }


    @Subscribe
    public void getFormalPhotos(ServiceCalls.SearchFormalPhotosRequest request){
        ServiceCalls.SearchFormalPhotosResponse response = new ServiceCalls.SearchFormalPhotosResponse();
        response.FormalEventPhotos = new ArrayList<>();

        response.FormalEventPhotos.add(new EventPhoto(
                1,
                "Formal",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/13064568_1103112769750114_5748895975103499421_o.jpg"));

        response.FormalEventPhotos.add(new EventPhoto(
                2,
                "Formal",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/13063035_1103115849749806_185469749096237505_o.jpg"

        ));



        response.FormalEventPhotos.add(new EventPhoto(
                3,
                "Formal",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/13047708_1103115976416460_8126889875746452282_o.jpg"
        ));

        bus.post(response);


    }
}
