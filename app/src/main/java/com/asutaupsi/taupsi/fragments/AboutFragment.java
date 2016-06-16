package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.asutaupsi.taupsi.views.InformationVideoAdapterList;
import com.asutaupsi.taupsi.views.InformationalVideoAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends BaseFragment {

    private final String LOG_TAG = AboutFragment.class.getSimpleName();
    private ListView aboutListView;
    private InformationVideoAdapterList adapter;

;


    public static AboutFragment newInstance(){
        return new AboutFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);
        adapter = new InformationVideoAdapterList((BaseActivity) getActivity());
        aboutListView = (ListView) view.findViewById(R.id.fragment_about_list_view);
        aboutListView.setAdapter(adapter);
        bus.post(new ServiceCalls.SearchCommunityVideosRequest(true));
        return view;
    }



    @Subscribe
    public void getCommunityVideos(final ServiceCalls.SearchCommuntiyVideosResponse response){
        adapter.clear();
        adapter.addAll(response.communityVideos);
        Log.i(LOG_TAG,Integer.toString(adapter.getCount()));
    }



}
