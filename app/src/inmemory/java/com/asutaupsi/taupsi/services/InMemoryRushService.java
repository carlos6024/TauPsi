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
    public void rushInformationalEvents(ServiceCalls.SearchRushInfoEventsRequest request){
        ServiceCalls.SearchRushInfoEventsResponse response = new ServiceCalls.SearchRushInfoEventsResponse();
        response.rushInfoEvents = new ArrayList<>();


        response.rushInfoEvents.add(new RushEvent(
                0,
                "Rush Informational #1",
                "08/23/2016",
                "8pm",
                "Education Building (ED 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first informational of the semester! Come and see what Tau Psi Omega is all about."));


        response.rushInfoEvents.add(new RushEvent(
                1,
                "Rush Informational #2(Downtown)",
                "08/24/2016",
                "8pm",
                "Cronkite (CRONK 202)",
                33.400508,
                -111.919977,
                true,
                true,
                "We also have love for all the gentleman downtown! Check out what being a jagur is all about."));





        response.rushInfoEvents.add(new RushEvent(
                2,
                "Rush Informational #3",
                "08/30/2016",
                "8pm",
                "Education Building (ED 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first informational of the semester! Come and see what Tau Psi Omega is all about."));

        response.rushInfoEvents.add(new RushEvent(
                3,
                "Rush Informational #4",
                "09/06/2016",
                "8pm",
                "Memorial Union (Mu 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the last week of rush! There is still time to meet are your requirements staring with this informational"));


        response.rushInfoEvents.add(new RushEvent(
                4,
                "Rush Informational #5(Downtown)",
                "09/07/2016",
                "8pm",
                "Memorial Union (Mu 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "Just in case we missed any more future brothers downtown."));


        bus.post(response);
    }



    @Subscribe
    public void rushSocialEvents(ServiceCalls.SearchRushSocialEventsRequest request){
        ServiceCalls.SearchRushSocialEventsResponse response = new ServiceCalls.SearchRushSocialEventsResponse();
        response.rushSocialEvents = new ArrayList<>();
        response.rushSocialEvents.add(new RushEvent(
                5,
                "Social",
                "08/25/2016",
                "8pm",
                "Cronkite (CRONK 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first informational of the semester! Come and see what Tau Psi Omega is all about."));



        response.rushSocialEvents.add(new RushEvent(
                6,
                "Rush Social #2",
                "09/01/2016",
                "8pm",
                "Cronkite (CRONK 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first informational of the semester! Come and see what Tau Psi Omega is all about."));



        response.rushSocialEvents.add(new RushEvent(
                7,
                "Rush Social #3",
                "09/08/2016",
                "8pm",
                "Cronkite (CRONK 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first informational of the semester! Come and see what Tau Psi Omega is all about."));

        bus.post(response);


    }



    @Subscribe
    public void rushServiceEvents(ServiceCalls.SearchRushCommunityEventsRequest request){
        ServiceCalls.SearchRushCommunityResponse response = new ServiceCalls.SearchRushCommunityResponse();
        response.rushCommunityEvents = new ArrayList<>();

        response.rushCommunityEvents.add(new RushEvent(
                8,
                "Community Service Event #1",
                "09/08/2016",
                "8pm",
                "Cronkite (CRONK 202)",
                33.400508,
                -111.919977,
                true,
                false,
                "This is the first service event in the rush process."));


        bus.post(response);

    }
}
