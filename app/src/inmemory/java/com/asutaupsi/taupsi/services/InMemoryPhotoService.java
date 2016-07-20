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




        response.BeALeaderPhotos.add(new EventPhoto(
                4,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13706215_1104684782918454_2083169119_n.jpg?oh=4d0fb7418be1ce847a0b8573a869cf1f&oe=578CFBF8"
        ));



        response.BeALeaderPhotos.add(new EventPhoto(
                5,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13689330_1104684786251787_2020575267_n.jpg?oh=82007cbc49ea4f32626553556f86da0f&oe=578E0A4E"
        ));



        response.BeALeaderPhotos.add(new EventPhoto(
                6,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t35.0-12/13699350_1104684792918453_361013506_o.jpg?oh=39ac1f6fa818afddafe659a9615fbae8&oe=578D206F"
        ));



        response.BeALeaderPhotos.add(new EventPhoto(
                7,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t35.0-12/13730597_1104684799585119_763336721_o.jpg?oh=abb59f6edd25694b50e40c3e45cc96a8&oe=578D44BE"
        ));


        response.BeALeaderPhotos.add(new EventPhoto(
                8,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13735424_1104684816251784_210086860_n.jpg?oh=33d1ede0b2cb93a9e83fbd7230301714&oe=578D0100"
        ));



        response.BeALeaderPhotos.add(new EventPhoto(
                9,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13689620_1104684819585117_1412970392_n.jpg?oh=73e361a42a5278aa10705d8a82de9032&oe=578D15C0"
        ));



        response.BeALeaderPhotos.add(new EventPhoto(
                10,
                "Be a Leader",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t35.0-12/13720673_1104684846251781_1966677752_o.jpg?oh=a4fd341faebfc795b8ad9406afba7a40&oe=578CD7A7"
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
