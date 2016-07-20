package com.asutaupsi.taupsi.services;

import android.util.Log;

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
    private final String LOG_TAG = LiveBrotherService.class.getSimpleName();

    public LiveBrotherService(TauPsiApplication application) {
        super(application);
    }

    @Subscribe
    public void loadBrothers(ServiceCalls.SearchBrothersRequest request) {
        final ServiceCalls.SearchBrothersResponse response = new ServiceCalls.SearchBrothersResponse();
        response.Brothers = new ArrayList<>();
        Firebase reference = new Firebase("https://asutaupsi-9d1d9.firebaseio.com/data/brothers");


        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                for (DataSnapshot brotherSnapchat : dataSnapshot.getChildren()) {
                    BrotherFireBase bro = brotherSnapchat.getValue(BrotherFireBase.class);
                    Log.i(LOG_TAG, bro.getName());
                    Log.i(LOG_TAG, bro.getWhy());
                    Log.i(LOG_TAG, bro.getPicture());
                    Log.i(LOG_TAG, bro.getMajor());
                    Log.i(LOG_TAG, bro.getCross());
                    Log.i(LOG_TAG, bro.getFact());


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

        Log.i(LOG_TAG, "Random statement");
    }
}
