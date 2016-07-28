package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.entities.FirebaseEntites.RushEventFireBase;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveRushService extends BaseLiveService {

    public LiveRushService(TauPsiApplication application) {
        super(application);
    }


    @Subscribe
    public void rushInformationalEvents(ServiceCalls.SearchRushInfoEventsRequest request){
        final ServiceCalls.SearchRushInfoEventsResponse response = new ServiceCalls.SearchRushInfoEventsResponse();

        response.rushInfoEvents = new ArrayList<>();
        Firebase reference = new Firebase(request.searchType);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                int index = 0;

                                for (DataSnapshot rushSnapshot : dataSnapshot.getChildren()) {
                                        RushEventFireBase rushEventFireBase = rushSnapshot.getValue(RushEventFireBase.class);

                                        RushEvent rushEvent = new RushEvent(
                                                index,
                                                rushEventFireBase.getName(),
                                                rushEventFireBase.getDate(),
                                                rushEventFireBase.getTime(),
                                                rushEventFireBase.getLocation(),
                                                rushEventFireBase.getLatitude(),
                                                rushEventFireBase.getLongitude(),
                                                rushEventFireBase.isAsu(),
                                                rushEventFireBase.isDowntown(),
                                                rushEventFireBase.getDescription());

                                        response.rushInfoEvents.add(rushEvent);
                                        index++;
                                }

                                bus.post(response);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                });
        }





        @Subscribe
        public void rushSocialEvents(ServiceCalls.SearchRushSocialEventsRequest request){
                final ServiceCalls.SearchRushSocialEventsResponse response = new ServiceCalls.SearchRushSocialEventsResponse();
                response.rushSocialEvents = new ArrayList<>();
                Firebase reference = new Firebase(request.searchType);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                int index = 0;
                                for (DataSnapshot rushSnapshot : dataSnapshot.getChildren()) {
                                        RushEventFireBase rushEventFireBase = rushSnapshot.getValue(RushEventFireBase.class);
                                        RushEvent rushEvent = new RushEvent(
                                                index,
                                                rushEventFireBase.getName(),
                                                rushEventFireBase.getDate(),
                                                rushEventFireBase.getTime(),
                                                rushEventFireBase.getLocation(),
                                                rushEventFireBase.getLatitude(),
                                                rushEventFireBase.getLongitude(),
                                                rushEventFireBase.isAsu(),
                                                rushEventFireBase.isDowntown(),
                                                rushEventFireBase.getDescription()
                                        );

                                        response.rushSocialEvents.add(rushEvent);
                                        index++;
                                }

                                bus.post(response);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                });


        }

        @Subscribe
        public void rushServiceEvents(ServiceCalls.SearchRushCommunityEventsRequest request){
                final ServiceCalls.SearchRushCommunityResponse response = new ServiceCalls.SearchRushCommunityResponse();
                response.rushCommunityEvents = new ArrayList<>();
                Firebase reference = new Firebase(request.searchType);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                int index = 0;
                                for (DataSnapshot rushSnapshot : dataSnapshot.getChildren()) {
                                        RushEventFireBase rushEventFireBase = rushSnapshot.getValue(RushEventFireBase.class);
                                        RushEvent rushEvent = new RushEvent(
                                                index,
                                                rushEventFireBase.getName(),
                                                rushEventFireBase.getDate(),
                                                rushEventFireBase.getTime(),
                                                rushEventFireBase.getLocation(),
                                                rushEventFireBase.getLatitude(),
                                                rushEventFireBase.getLongitude(),
                                                rushEventFireBase.isAsu(),
                                                rushEventFireBase.isDowntown(),
                                                rushEventFireBase.getDescription()
                                        );
                                        response.rushCommunityEvents.add(rushEvent);
                                        index++;
                                }

                            bus.post(response);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                });

        }



}
