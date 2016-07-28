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
    public void getCommunityInforamtionCards(ServiceCalls.SearchCommunityInformationRequest request){
        ServiceCalls.SearchCommunityInformationResponse response = new ServiceCalls.SearchCommunityInformationResponse();
        response.communityInformationList = new ArrayList<>();

        response.communityInformationList.add(new InformationCard(
                        1,"Without Borders (Sin Fronteras)......>","Around November, we make our annual service trip to the town of Hermosillo, Sonora Mexico. Once there we deliver food and toys to the families in the community."
                        ,"Service","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/9763_805171952877532_8416560338607406648_n.jpg?oh=b6fbdb8bd623139b673604bf2180154b&oe=5806CD18","wzO7rK50P8w",true)
        );

        response.communityInformationList.add(
                new InformationCard(2,
                        "Be a Leader","Our philanthropy is promoting higher education to the youth. To do this, we partnered with the Be a Leader Foundation to help mentor students about the aspects of college.",
                        "Service","https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/10644405_767323046662423_2721762627528987226_o.jpg",null,false)
        );

        bus.post(response);
    }


    @Subscribe
    public void getBrotherHoodInformationCards(ServiceCalls.SearchBrotherhoodInformationRequest request){
        ServiceCalls.SearchBrotherhoodInformationResponse response = new ServiceCalls.SearchBrotherhoodInformationResponse();
        response.brotherHoodInformationList = new ArrayList<>();

        response.brotherHoodInformationList.add( new InformationCard(
                3,"Traveling","From visiting Turkey for spring break to Singapore for a BrotherFireBase" +
                " wedding, here are some of the adventures our BrotherFireBase shared together.","Brotherhood",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12688110_10207553594890834_6811133184583623525_n.jpg?oh=365ac0b7bc80beeecdd920c7fd178ffd&oe=580FE07C","",false));


        response.brotherHoodInformationList.add(new InformationCard(
                4,"Graduation","Above all, the mission of the fraternity is to graduate BrotherFireBase. Attending graduation every semester and watching our BrotherFireBase walk the stage is the ultimate brotherhood event.","Brotherhood",
                        "https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/13147780_1116200035108054_2287358440528092965_o.jpg","RGJW0lni76w",true));

        bus.post(response);
    }


    @Subscribe
    public void getSocialCards(ServiceCalls.SearchSocialInformationRequest request){
        ServiceCalls.SearchSocialInformationResponse response = new ServiceCalls.SearchSocialInformationResponse();
        response.socialVideos = new ArrayList<>();


        response.socialVideos.add(
                new InformationCard(5,"Sexy Showcase","During the time of Valentines Day, we host the Sexy Showcase which is designed to promote sexual awareness.",
                        "Social","https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/12485847_1043898569004868_2273001470333005359_o.jpg","o7OiiTRqExs",false));

        response.socialVideos.add(
                new InformationCard(6,"Strolling","Strolling is a dance performance that showcase synchronized movements. We perform these strolls as both for fun and for competition. Here is a recap of one of our recent stroll competitions..",
                        "Social","https://scontent.fphx1-2.fna.fbcdn.net/t31.0-8/1899319_662335587161170_2028780192_o.jpg","JAOXPIY7xOs",true)
        );


        bus.post(response);
    }


}
