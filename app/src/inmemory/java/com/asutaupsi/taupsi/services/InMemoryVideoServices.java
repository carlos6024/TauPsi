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
        ServiceCalls.SearchCommunityVideosResponse response = new ServiceCalls.SearchCommunityVideosResponse();
        response.communityVideos = new ArrayList<>();

        for(int i=0; i<1;i++ ){
            response.communityVideos.add(
                    new InformationVideo(i,"Sin Fronteras","Every year Tau psi Omega takes a trip down to mexico in oder to give back,"
                    ,"Service","http://www.gravatar.com/avatar/" + 1 + "?d=identicon","wzO7rK50P8w")
            );
        }

        bus.post(response);
    }


    @Subscribe
    public void getSocialVideos(ServiceCalls.SearchSocialVideosRequest request){
        ServiceCalls.SearchSocialVideosReponse response = new ServiceCalls.SearchSocialVideosReponse();
        response.socialVideos = new ArrayList<>();


        for(int i = 0;i<1;i++){
            response.socialVideos.add(
                    new InformationVideo(i,"Sexy Showcase","Valentines Day is a day of love and we promote sex awarness",
                            "Social","http://www.gravatar.com/avatar/" + 2 + "?d=identicon","o7OiiTRqExs")
            );

        }
        bus.post(response);
    }


    @Subscribe
    public void getAcademicsVideos(ServiceCalls.SearchAcademicsVideosRequest request){
        ServiceCalls.SearchAcademicsVideosResponse response = new ServiceCalls.SearchAcademicsVideosResponse();
        response.academicVideos = new ArrayList<>();


        for(int i=0;i<1;i++){
            response.academicVideos.add(
                    new InformationVideo(i,"Graduation","Above all, Tau Psi Omegas mission is to graduate our brothers here is the class of" +
                            "2015","Academics","http://www.gravatar.com/avatar/" + 3 + "?d=identicon","RGJW0lni76w")
            );
        }
        bus.post(response);
    }
}
