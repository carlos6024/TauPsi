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
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.asutaupsi.taupsi.services.entities.RushEvent;
import com.asutaupsi.taupsi.views.InformationalVideoRecyclerAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class AboutFragment extends BaseFragment implements InformationalVideoRecyclerAdapter.OnInformationalVideoClickListener {
    private final String LOG_TAG = AboutFragment.class.getSimpleName();

    private InformationalVideoRecyclerAdapter adapter;
    private ArrayList<InformationVideo> informationVideos;

    public static AboutFragment newInstance(){
            return new AboutFragment();
    }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_about,container,false);
            adapter = new InformationalVideoRecyclerAdapter((BaseActivity) getActivity(),this);
            informationVideos = adapter.getVideos();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_about_list_view);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            bus.post(new ServiceCalls.SearchCommunityVideosRequest(true));
            return view;
        }



    @Subscribe
        public void getCommunityVideos1(final ServiceCalls.SearchCommuntiyVideosResponse response){
            informationVideos.clear();
            informationVideos.addAll(response.communityVideos);
            Log.i(LOG_TAG,Integer.toString(informationVideos.size()));
        }


    @Override
    public void onInformationClicked(InformationVideo video) {
        Log.i(LOG_TAG,video.getVideoYoutubeEnding());
    }


}
