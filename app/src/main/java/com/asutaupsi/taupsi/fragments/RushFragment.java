package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.asutaupsi.taupsi.views.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {
    private final String LOG_TAG = RushFragment.class.getSimpleName();
    private RushEventAdapter adapter;

    private ArrayList<RushEvent> rushEvents;
    public static RushFragment newInstance(){
        return new RushFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rush, container, false);
        adapter = new RushEventAdapter(this,(BaseActivity) getActivity());
        rushEvents = adapter.getRushEvents();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment__rush_recycled_view_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bus.post(new ServiceCalls.SearchRushEventsRequest("Hello"));
        return view;
    }




    @Subscribe
    public void onRushEventsLoaded(final ServiceCalls.SearchRushEventsResponse response){
        rushEvents.clear();
        rushEvents.addAll(response.rushEvents);
        Log.i(LOG_TAG, Integer.toString(rushEvents.size()) + " Rush Events Found" );
    }


    @Override
    public void onRushEventClicked(RushEvent rushEvent) {

    }
}