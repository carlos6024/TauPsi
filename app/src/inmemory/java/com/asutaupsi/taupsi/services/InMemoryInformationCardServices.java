package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryInformationCardServices extends BaseInMemeoryService {
    public InMemoryInformationCardServices(TauPsiApplication application) {
        super(application);
    }



    @Subscribe
    public void getCommunityVideos(ServiceCalls.SearchCommunityInformationRequest request){
        ServiceCalls.SearchCommunityInformationResponse response = new ServiceCalls.SearchCommunityInformationResponse();
        response.communityInformationList = new ArrayList<>();

        response.communityInformationList.add(
                    new InformationCard(1,"Sin Fronteras","Every year Tau psi Omega takes a trip down to mexico in oder to give back,"
                    ,"Service","http://www.gravatar.com/avatar/" + 1 + "?d=identicon","wzO7rK50P8w",true)
        );




        bus.post(response);
    }


    @Subscribe
    public void getSocialCards(ServiceCalls.SearchSocialInformationRequest request){
        ServiceCalls.SearchSocialInformationResponse response = new ServiceCalls.SearchSocialInformationResponse();
        response.socialVideos = new ArrayList<>();


        response.socialVideos.add(
                new InformationCard(1,"Sexy Showcase","Valentines Day is a day of love and we promote sex awarness",
                        "Social","http://www.gravatar.com/avatar/" + 2 + "?d=identicon","o7OiiTRqExs",true));

        response.socialVideos.add(
                new InformationCard(2,"Formal","At the end of the year, brothers both undergraduate and alumni gather to celebrate. Here are some photos from last years event",
                        "Social","http://www.gravatar.com/avatar/" + 3 + "?d=identicon","o7OiiTRqExs",false)
        );


        bus.post(response);
    }


    @Subscribe
    public void getAcademicsVideos(ServiceCalls.SearchAcademicsInformationRequest request){
        ServiceCalls.SearchAcademicsInformationResponse response = new ServiceCalls.SearchAcademicsInformationResponse();
        response.academicInformationList = new ArrayList<>();


        response.academicInformationList.add(
                    new InformationCard(1,"Graduation","Above all, Tau Psi Omegas mission is to graduate our brothers here is the class of" +
                            "2015","Academics","http://www.gravatar.com/avatar/" + 4 + "?d=identicon","RGJW0lni76w",true));


        bus.post(response);
    }
}
