package com.asutaupsi.taupsi.infrastructure;

import android.app.Application;

import com.asutaupsi.taupsi.services.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

public class TauPsiApplication extends Application {
    private Bus bus;

    public static final String YOUTUBE_API_KEY = "";

    public static final String BROTHER_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/brothers";

    public static final String COMMUNITY_INFORMATION_CARD_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/communityCard";
    public static final String SOCIAL_INFORMATION_CARD_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/socialCard";
    public static final String BROTHERHOOD_INFORMATION_CARD_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/brotherHoodCard";

    public static final String COMMUNITY_PHOTOS_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/communityServicePics";
    public static final String TRAVELING_PHOTOS_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/travelingPics";
    public static final String SEXYSHOWCASE_PHOTOS_REFRENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/sexyShowcasePics";


    public static final String RUSH_INFORMATIONAL_EVENTS_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/rushInformationEvents";
    public static final String RUSH_SOCIAL_EVENTS_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/rushSocialEvents";
    public static final String RUSH_SERVICE_EVENTS_REFERENCE = "https://asutaupsi-9d1d9.firebaseio.com/data/rushCommunityEvents";







    public TauPsiApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        Module.register(this);
    }


    public Bus getBus() {
        return bus;
    }


}
