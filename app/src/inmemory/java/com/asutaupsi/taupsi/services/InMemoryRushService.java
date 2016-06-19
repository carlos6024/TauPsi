package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.entities.RushEvent;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryRushService extends BaseInMemeoryService {
    public InMemoryRushService(TauPsiApplication application) {
        super(application);
    }


    @Subscribe
    public void findRushEvents(ServiceCalls.SearchRushEventsRequest request){
        ServiceCalls.SearchRushEventsResponse response = new ServiceCalls.SearchRushEventsResponse();
        response.rushEvents = new ArrayList<>();


        for(int i = 0 ; i<5 ;i++){
            String stringId = Integer.toString(i);

            response.rushEvents.add(new RushEvent(
                    i,
                    "Rush Event "+ stringId,
                    "Informational",
                    "8/24/2016",
                    "7pm",
                    "ED 202",
                    2.5,
                    2.5));
        }

        bus.post(response);
    }
}
