package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.entities.Brother;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryBrotherService extends BaseInMemeoryService {
    public InMemoryBrotherService(TauPsiApplication application) {
        super(application);
    }


    @Subscribe
    public void findBrother(final ServiceCalls.SearchBrothersRequest request){
        ServiceCalls.SearchBrothersResponse response = new ServiceCalls.SearchBrothersResponse();
        response.Brothers = new ArrayList<>();

        response.Brothers.add(new Brother(1,"Carlos Valentin", "In high school I enjoyed giving back to my community. I joined the fraternity" +
                "as a way to continue doing so.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/12279247_1732096447019772_1569305391006180529_n.jpg?oh=d730283cab5aa466b8ca20c10d81e9ee&oe=57FAE988",
                "Mechanical Engineering"
                ,"Spring 2013",
                "I made the developer of this app! Well the android version lol"
                ));


        response.Brothers.add(new Brother(2,"Juan Panduro", "I joined Tau Psi Omega for a support system. What I got was a family",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13346561_1105969719441159_11085801372326366_n.jpg?oh=00f2d53a8143989396b55e048ab1bc8e&oe=58074EFC",
                "Industrial Engineering"
                ,"Spring 2016",
                "I am about about that truck life!"
        ));


        response.Brothers.add(new Brother(3,"Jorge Poncho Calderon", "I wanted a family away from home and I wanted to make a difference within the organization.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13432367_1329346337079507_7655884061677951407_n.jpg?oh=c15542e8775c734903ccbce7f79e6926&oe=57ED11E6",
                "Family and Human Development"
                ,"Fall 2011",
                "Call of duty is my favorite game!"
        ));



        response.Brothers.add(new Brother(4,"Andres Calzadias", "I wanted a family away from home and I wanted to make a difference within the organization.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13096017_523231151196987_1210654285430385905_n.jpg?oh=5b668d646c1bacc970084120320f84cd&oe=57F3B6A5",
                "Business Law "
                ,"Fall 2015",
                "I aspire to join the marines!"
        ));



        response.Brothers.add(new Brother(5,"Juan Reyes", "I joined the fraternity because I wanted to get involved at the organization as ASU well serve my community. Tau Psi Omega was that and the support system I neeeded",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13530683_1062224167199288_1269430085_n.jpg?oh=f8358f819e4b7bb827e59a0397272ec8&oe=57715B8B",
                "Nonprofit Leadership and Mangement"
                ,"Fall 2012",
                "I am left handed!"
        ));



        /*for(int i = 0 ; i<5;i++){
            String stringId = Integer.toString(i);

            response.Brothers.add(new Brother(i,
                    "Brother " + i,
                    "My name is Brother " + i + " and I love to Code my heart out!!!",
                    "http://www.gravatar.com/avatar/" + stringId + "?d=identicon",
                    "Mechanical Engineering",
                    "Spring 2013",
                    "I made this app"));
        }*/
        bus.post(response);
    }
}
