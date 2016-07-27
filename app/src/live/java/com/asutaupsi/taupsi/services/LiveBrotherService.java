package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.entities.FirebaseEntites.BrotherFireBase;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveBrotherService extends BaseLiveService {

    public LiveBrotherService(TauPsiApplication application) {
        super(application);
    }

    @Subscribe
    public void loadBrothers(ServiceCalls.SearchBrothersRequest request) {
        final ServiceCalls.SearchBrothersResponse response = new ServiceCalls.SearchBrothersResponse();
        response.Brothers = new ArrayList<>();

        Firebase reference = new Firebase(request.getSearchType());


        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                for (DataSnapshot brotherSnapchat : dataSnapshot.getChildren()) {
                    BrotherFireBase bro = brotherSnapchat.getValue(BrotherFireBase.class);

                    Brother brother = new Brother(
                            index,
                            bro.getName(),
                            bro.getWhy(),
                            bro.getPicture(),
                            bro.getMajor(),
                            bro.getCross(),
                            bro.getFact());

                    response.Brothers.add(brother);
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
