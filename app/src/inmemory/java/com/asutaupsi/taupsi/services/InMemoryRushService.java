package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.entities.RushEvent;
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

        response.rushEvents.add(new RushEvent(
                1,
                "Passport",
                "Informational",
                "8/17/2016",
                "7pm",
                "Memorial Union",
                2.5,
                2.5,
                true,
                "Come and meet us before the semester starts at ASU Passport!"));

        response.rushEvents.add(new RushEvent(
                2,
                "Poker Night",
                "Social",
                "9/01/2016",
                "7pm",
                "1126 E Alemeda Dr. Tempe, AZ 85282",
                33.400508,
                -111.919977,
                false,
                "Try out your poker face against the brothers this night, winner take all!"));


        bus.post(response);
    }
}
