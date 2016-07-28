package com.asutaupsi.taupsi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.activities.EventPhotoPagerActivity;
import com.asutaupsi.taupsi.activities.YoutubePlayerActivity;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.asutaupsi.taupsi.views.AboutUsViews.AboutUsFragmentAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class AboutFragment extends BaseFragment implements AboutUsFragmentAdapter.AboutUsListener {

    private ArrayList<InformationCard> communityCards;
    private ArrayList<InformationCard> socialCards;
    private ArrayList<InformationCard> academicsCards;
    private AboutUsFragmentAdapter adapter;



    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";

    public static AboutFragment newInstance(){
            return new AboutFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);
        adapter = new AboutUsFragmentAdapter((BaseActivity) getActivity(),this);
        communityCards = adapter.getCommunityCards();
        academicsCards = adapter.getBrotherhoodCards();
        socialCards = adapter.getSocialCards();


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_about_recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bus.post(new ServiceCalls.SearchCommunityInformationRequest(TauPsiApplication.COMMUNITY_INFORMATION_CARD_REFERENCE));
        bus.post(new ServiceCalls.SearchBrotherhoodInformationRequest(TauPsiApplication.BROTHERHOOD_INFORMATION_CARD_REFERENCE));
        bus.post(new ServiceCalls.SearchSocialInformationRequest(TauPsiApplication.SOCIAL_INFORMATION_CARD_REFERENCE));
        return view;
    }



    @Subscribe
    public void getCommunityCards(final ServiceCalls.SearchCommunityInformationResponse response){
        int oldSize = communityCards.size();
        if(oldSize ==0){
            communityCards.clear();
            adapter.notifyItemRangeRemoved(0,oldSize);
            communityCards.addAll(response.communityInformationList);
            adapter.notifyItemRangeChanged(0, communityCards.size());
        } else{
            return;
        }

    }

    @Subscribe
    public void getSocialCards(final ServiceCalls.SearchSocialInformationResponse respose){
        int oldSize = socialCards.size();

        if(oldSize ==0){
            socialCards.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            socialCards.addAll(respose.socialVideos);
            adapter.notifyItemRangeChanged(0, socialCards.size());
        } else{
            return;
        }
    }

    @Subscribe
    public void getBrotherhoodCards(final ServiceCalls.SearchBrotherhoodInformationResponse response){
        int oldSize = academicsCards.size();

        if(oldSize ==0){
            academicsCards.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            academicsCards.addAll(response.brotherHoodInformationList);
            adapter.notifyItemRangeChanged(0, academicsCards.size());

        } else{
            return;
        }
    }


    @Override
    public void onInformationVideoClicked(InformationCard informationCard) {

        if(!informationCard.getIsVideo()){
            Intent intent = new Intent(getActivity(),EventPhotoPagerActivity.class);
            intent.putExtra(EXTRA_VIDEO_INFO,informationCard);
            startActivity(intent);
        }

        else {
            Intent intent = new Intent(getActivity(), YoutubePlayerActivity.class);
            intent.putExtra(EXTRA_VIDEO_INFO, informationCard.getVideoYoutubeEnding());
            startActivity(intent);
        }
    }
}
