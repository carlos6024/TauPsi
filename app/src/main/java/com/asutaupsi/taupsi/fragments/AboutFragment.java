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
import com.asutaupsi.taupsi.views.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class AboutFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {
    private final String LOG_TAG = AboutFragment.class.getSimpleName();

    private AboutUsAdapter adapter;
    private ArrayList<InformationVideo> communityVideos;
    private ArrayList<InformationVideo> socialVideos;
    private ArrayList<InformationVideo> academicsVideos;

    public static AboutFragment newInstance(){
            return new AboutFragment();
    }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_about,container,false);
            adapter = new AboutUsAdapter((BaseActivity) getActivity(),this);
            communityVideos = adapter.getCommunityVideos();
            academicsVideos = adapter.getAcademicVideos();
            socialVideos = adapter.getSocialVideos();

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_about_recycler_view);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            bus.post(new ServiceCalls.SearchCommunityVideosRequest(true));
            bus.post(new ServiceCalls.SearchAcademicsVideosRequest(true));
            bus.post(new ServiceCalls.SearchSocialVideosRequest(true));
            return view;
        }



    @Subscribe
    public void getCommunityVideos(final ServiceCalls.SearchCommunityVideosResponse response){
            communityVideos.clear();
            communityVideos.addAll(response.communityVideos);
            Log.i(LOG_TAG, Integer.toString(communityVideos.size()) + " community Videos Added");
        }

    @Subscribe
    public void getSocialVideos(final ServiceCalls.SearchSocialVideosReponse respose){
        socialVideos.clear();
        socialVideos.addAll(respose.socialVideos);
        Log.i(LOG_TAG,Integer.toString(socialVideos.size()) + " social Videos Added");
    }

    @Subscribe
    public void getAcademicsVideos(final  ServiceCalls.SearchAcademicsVideosResponse response){
        academicsVideos.clear();
        academicsVideos.addAll(response.academicVideos);
        Log.i(LOG_TAG,Integer.toString(academicsVideos.size()) + " academics Videos Added");
    }


    @Override
    public void onInformationVideoClicked(InformationVideo video) {
        Log.i(LOG_TAG,video.getVideoYoutubeEnding());
    }

}
