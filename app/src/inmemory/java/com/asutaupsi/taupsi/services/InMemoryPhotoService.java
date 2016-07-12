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
    public void getBeALeaderPhotos(ServiceCalls.SearchBeALeaderPhotosRequest request){
        ServiceCalls.SearchBeALeaderPhotosResponse response = new ServiceCalls.SearchBeALeaderPhotosResponse();
        response.BeALeaderPhotos = new ArrayList<>();

        response.BeALeaderPhotos.add(new EventPhoto(
                1,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/10515360_767322703329124_1972471271627762550_o.jpg"));

        response.BeALeaderPhotos.add(new EventPhoto(
                2,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/10669035_767323543329040_5532275335749028307_o.jpg"

        ));

        response.BeALeaderPhotos.add(new EventPhoto(
                3,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/1093960_767323276662400_2479322106909630232_o.jpg"
        ));

        bus.post(response);
    }


    @Subscribe
    public void getTravelingPhotos (ServiceCalls.SearchTravelingPhotosRequest request){
        ServiceCalls.SearchTravelingPhotosResponse response = new ServiceCalls.SearchTravelingPhotosResponse();
        response.TravelingEventPhotos = new ArrayList<>();

        response.TravelingEventPhotos.add(new EventPhoto(
                1,
                "Traveling",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/2003_701588026649781_749213583016505235_n.jpg?oh=88c29584b6199abc334456fe9ff5037d&oe=57F8273A"
        ));

        response.TravelingEventPhotos.add(new EventPhoto(
                2,
                "Traveling",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/22519_10206537887270059_878108307086703799_n.jpg?oh=50e0d5bbd21b1aed7d8329a171f1de42&oe=5801537E"
        ));


        response.TravelingEventPhotos.add(new EventPhoto(
                3,
                "Traveling",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/11081256_10206537888750096_6205196432031841833_n.jpg?oh=45e41185c52c3f7c02960869080f64c7&oe=57EE53D2"
        ));

        bus.post(response);
    }


    @Subscribe
    public void getSexyShowCasePhotos(ServiceCalls.SearchSexyShowCaseRequest request){
        ServiceCalls.SearchSexyShowcaseResponse response = new ServiceCalls.SearchSexyShowcaseResponse();
        response.SexyShowCasePhotos = new ArrayList<>();

        response.SexyShowCasePhotos.add( new EventPhoto(
                1,
                "Sexy ShowCase",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/12792326_1064912280236830_5863307930949274811_o.jpg"
        ));


        response.SexyShowCasePhotos.add( new EventPhoto(
                2,
                "Sexy ShowCase",
                "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/12487113_1043898769004848_4935500286418130817_o.jpg"));



        response.SexyShowCasePhotos.add( new EventPhoto(
                3,
                "Sexy ShowCase",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/10610557_860738367320890_8969041469781293038_n.jpg?oh=6b0ee4a09825733e665683e4f918876a&oe=57F84EC0"));


    bus.post(response);
    }


}
