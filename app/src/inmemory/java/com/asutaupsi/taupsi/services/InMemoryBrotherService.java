package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.entities.Brother;
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

        for(int i = 0 ; i<5;i++){
            String stringId = Integer.toString(i);

            response.Brothers.add(new Brother(i,
                    "Brother " + i,
                    "My name is Brother " + i + " and I love to Code my heart out!!!",
                    "http://www.gravatar.com/avatar/" + stringId + "?d=identicon",
                    "Mechanical Engineering",
                    "Spring 2013",
                    "I made this app"));
        }
        bus.post(response);
    }
}
