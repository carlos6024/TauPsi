package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.entities.InformationCard;
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

        response.communityVideos.add(
                    new InformationCard(1,"Sin Fronteras","Every year Tau psi Omega takes a trip down to mexico in oder to give back,"
                    ,"Service","http://www.gravatar.com/avatar/" + 1 + "?d=identicon","wzO7rK50P8w",true)
        );




        bus.post(response);
    }


    @Subscribe
    public void getSocialVideos(ServiceCalls.SearchSocialVideosRequest request){
        ServiceCalls.SearchSocialVideosReponse response = new ServiceCalls.SearchSocialVideosReponse();
        response.socialVideos = new ArrayList<>();


        response.socialVideos.add(
                new InformationCard(1,"Sexy Showcase","Valentines Day is a day of love and we promote sex awarness",
                        "Social","http://www.gravatar.com/avatar/" + 2 + "?d=identicon","o7OiiTRqExs",true));

        response.socialVideos.add(
                new InformationCard(2,"Formal","At the end of the semester, brothers both undergraduate and alumni gather to celebrate the end of the year",
                        "Social","http://www.gravatar.com/avatar/" + 3 + "?d=identicon","o7OiiTRqExs",false)
        );


        bus.post(response);
    }


    @Subscribe
    public void getAcademicsVideos(ServiceCalls.SearchAcademicsVideosRequest request){
        ServiceCalls.SearchAcademicsVideosResponse response = new ServiceCalls.SearchAcademicsVideosResponse();
        response.academicVideos = new ArrayList<>();


        response.academicVideos.add(
                    new InformationCard(1,"Graduation","Above all, Tau Psi Omegas mission is to graduate our brothers here is the class of" +
                            "2015","Academics","http://www.gravatar.com/avatar/" + 4 + "?d=identicon","RGJW0lni76w",true));


        bus.post(response);
    }
}
