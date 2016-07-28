package com.asutaupsi.taupsi.services;


import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.entities.FirebaseEntites.EventPhotoFireBase;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LivePhotoService extends BaseLiveService {
    public LivePhotoService(TauPsiApplication application) {
        super(application);
    }

    @Subscribe
    public void getBeALeaderPhotos(ServiceCalls.SearchBeALeaderPhotosRequest request){
        final ServiceCalls.SearchBeALeaderPhotosResponse response = new ServiceCalls.SearchBeALeaderPhotosResponse();
        response.BeALeaderPhotos = new ArrayList<>();
        Firebase reference = new Firebase(request.SearchParameter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPhotoFireBase photoFireBase = dataSnapshot1.getValue(EventPhotoFireBase.class);
                    EventPhoto eventPhoto = new EventPhoto(
                            index,
                            photoFireBase.getUrl()
                    );
                    response.BeALeaderPhotos.add(eventPhoto);
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
    public void getTravelingPhotos (ServiceCalls.SearchTravelingPhotosRequest request){
        final ServiceCalls.SearchTravelingPhotosResponse response = new ServiceCalls.SearchTravelingPhotosResponse();
        response.TravelingEventPhotos = new ArrayList<>();

        Firebase reference = new Firebase(request.SearchParameter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPhotoFireBase photoFireBase = dataSnapshot1.getValue(EventPhotoFireBase.class);
                    EventPhoto eventPhoto = new EventPhoto(
                            index,
                            photoFireBase.getUrl()
                    );
                    response.TravelingEventPhotos.add(eventPhoto);
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
    public void getSexyShowCasePhotos(ServiceCalls.SearchSexyShowCaseRequest request){
        final ServiceCalls.SearchSexyShowcaseResponse response = new ServiceCalls.SearchSexyShowcaseResponse();
        response.SexyShowCasePhotos = new ArrayList<>();
        Firebase reference = new Firebase(request.SearchParameter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPhotoFireBase photoFireBase = dataSnapshot1.getValue(EventPhotoFireBase.class);
                    EventPhoto eventPhoto = new EventPhoto(
                            index,
                            photoFireBase.getUrl()
                    );
                    response.SexyShowCasePhotos.add(eventPhoto);
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
