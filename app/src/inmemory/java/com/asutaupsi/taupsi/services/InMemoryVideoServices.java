package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryVideoServices extends BaseInMemeoryService {
    public InMemoryVideoServices(TauPsiApplication application) {
        super(application);
    }



    @Subscribe
    public void getCommunityVideos(ServiceCalls.SearchCommunityVideosRequest request){
        ServiceCalls.SearchCommuntiyVideosResponse response = new ServiceCalls.SearchCommuntiyVideosResponse();
        response.communityVideos = new ArrayList<>();

        for(int i=0; i<3;i++ ){
            String stringId = Integer.toString(i);
            response.communityVideos.add(
                    new InformationVideo(i,"Sin Fronteras","Every year Tau psi Omega takes a trip down to mexico in oder to give back,"
                    ,"Service","http://www.gravatar.com/avatar/" + stringId + "?d=identicon","wzO7rK50P8w")
            );
        }

        bus.post(response);

    }
}
