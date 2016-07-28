package com.asutaupsi.taupsi.services;


import com.asutaupsi.taupsi.entities.FirebaseEntites.InfoCardFireBase;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveInfoCardService extends BaseLiveService {

    public LiveInfoCardService(TauPsiApplication application) {
        super(application);
    }

    @Subscribe
    public void getCommunityInforamtionCards(ServiceCalls.SearchCommunityInformationRequest request){
        final ServiceCalls.SearchCommunityInformationResponse response = new ServiceCalls.SearchCommunityInformationResponse();
        response.communityInformationList = new ArrayList<>();

        Firebase reference = new Firebase(request.SearchParam);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot communitySnapshot : dataSnapshot.getChildren()) {
                    InfoCardFireBase communityInfo = communitySnapshot.getValue(InfoCardFireBase.class);

                    InformationCard informationCard = new InformationCard(
                            index,
                            communityInfo.getTitle(),
                            communityInfo.getDescription(),
                            communityInfo.getType(),
                            communityInfo.getPicture(),
                            communityInfo.getUrl(),
                            communityInfo.isVideo()
                    );

                    response.communityInformationList.add(informationCard);
                    index ++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Subscribe
    public void getBrotherHoodInformationCards(ServiceCalls.SearchBrotherhoodInformationRequest request){
        final ServiceCalls.SearchBrotherhoodInformationResponse response = new ServiceCalls.SearchBrotherhoodInformationResponse();
        response.brotherHoodInformationList = new ArrayList<>();

        Firebase reference = new Firebase(request.SearchParam);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 3;

                for (DataSnapshot brotherhoodCard : dataSnapshot.getChildren()) {
                    InfoCardFireBase brotherhoodInfo = brotherhoodCard.getValue(InfoCardFireBase.class);

                    InformationCard informationCard = new InformationCard(
                            index,
                            brotherhoodInfo.getTitle(),
                            brotherhoodInfo.getDescription(),
                            brotherhoodInfo.getType(),
                            brotherhoodInfo.getPicture(),
                            brotherhoodInfo.getUrl(),
                            brotherhoodInfo.isVideo()
                    );


                    response.brotherHoodInformationList.add(informationCard);
                    index ++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Subscribe
    public void getSocialCards(ServiceCalls.SearchSocialInformationRequest request){
        final ServiceCalls.SearchSocialInformationResponse response = new ServiceCalls.SearchSocialInformationResponse();
        response.socialVideos = new ArrayList<>();
        Firebase reference = new Firebase(request.SearchParam);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =5;

                for(DataSnapshot socialCards: dataSnapshot.getChildren()){
                    InfoCardFireBase socialCard = socialCards.getValue(InfoCardFireBase.class);

                    InformationCard informationCard = new InformationCard(
                            index,
                            socialCard.getTitle(),
                            socialCard.getDescription(),
                            socialCard.getType(),
                            socialCard.getPicture(),
                            socialCard.getUrl(),
                            socialCard.isVideo()
                    );

                    response.socialVideos.add(informationCard);
                    index ++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
