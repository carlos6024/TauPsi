package com.asutaupsi.taupsi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.AsuMapActivity;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.activities.MapsActivity;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.asutaupsi.taupsi.views.RushViews.Item;
import com.asutaupsi.taupsi.views.RushViews.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {
    private RushEventAdapter adapter;
    private ArrayList<RushEvent> rushInformationalEvents;
    private ArrayList<RushEvent> rushSocialEvents;
    private ArrayList<RushEvent> rushCommunityEvents;
    private RecyclerView recyclerView;

    private Item information;
    private Item community;
    private Item social;

    private final static String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";


    public static RushFragment newInstance(){
        return new RushFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rush, container, false);

        adapter = new RushEventAdapter((BaseActivity) getActivity(),this);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment__rush_recycled_view_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rushInformationalEvents = new ArrayList<>();
        rushSocialEvents = new ArrayList<>();
        rushCommunityEvents = new ArrayList<>();

        List<Item> data = adapter.getData();


        information = new Item(RushEventAdapter.HEADER,"Informationals");
        information.invisibleChildren = new ArrayList<>();
        community = new Item(RushEventAdapter.HEADER,"Service");
        community.invisibleChildren = new ArrayList<>();
        social = new Item(RushEventAdapter.HEADER,"Socials");
        social.invisibleChildren = new ArrayList<>();

        bus.post(new ServiceCalls.SearchRushInfoEventsRequest(TauPsiApplication.RUSH_INFORMATIONAL_EVENTS_REFERENCE));
        bus.post(new ServiceCalls.SearchRushCommunityEventsRequest(TauPsiApplication.RUSH_SERVICE_EVENTS_REFERENCE));
        bus.post(new ServiceCalls.SearchRushSocialEventsRequest(TauPsiApplication.RUSH_SOCIAL_EVENTS_REFERENCE));

        setUpAdapter();

        data.add(information);
        data.add(community);
        data.add(social);
        return view;
    }


    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }



    @Subscribe
    public void onRushInformationalLoaded(final ServiceCalls.SearchRushInfoEventsResponse response){

        rushInformationalEvents.clear();
        rushInformationalEvents.addAll(response.rushInfoEvents);
        for(RushEvent rushEvent: rushInformationalEvents){
            information.invisibleChildren.add(new Item(RushEventAdapter.CHILD,rushEvent));
        }
     }



    @Subscribe
    public void onRushCommunityLoaded(final ServiceCalls.SearchRushCommunityResponse response){
            rushCommunityEvents.clear();
            rushCommunityEvents.addAll(response.rushCommunityEvents);
            for(RushEvent rushEvent:rushCommunityEvents){
                community.invisibleChildren.add(new Item(RushEventAdapter.CHILD,rushEvent));
            }
    }





    @Subscribe
    public void onRushSocialLoaded(final ServiceCalls.SearchRushSocialEventsResponse response){
        rushSocialEvents.clear();
        rushSocialEvents.addAll(response.rushSocialEvents);
        for(RushEvent rushEvent:rushSocialEvents){
            social.invisibleChildren.add(new Item(RushEventAdapter.CHILD,rushEvent));
        }
    }



    @Override
    public void onRushEventClicked(RushEvent rushEvent) {
        if(!rushEvent.isAtAsu()){
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            intent.putExtra(RUSH_EVENT_INFO,rushEvent);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getActivity(),AsuMapActivity.class);
            intent.putExtra(RUSH_EVENT_INFO,rushEvent);
            startActivity(intent);
        }
    }
}