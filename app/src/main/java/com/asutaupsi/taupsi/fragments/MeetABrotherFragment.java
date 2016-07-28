package com.asutaupsi.taupsi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.activities.BrotherPagerActivity;
import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.views.BrotherViews.BrotherRecycleAdapter;
import com.squareup.otto.Subscribe;


import java.util.ArrayList;

public class MeetABrotherFragment extends BaseFragment implements BrotherRecycleAdapter.OnBrotherClickedListener {


    public static ArrayList<Brother> brothers;
    private RecyclerView recyclerView;
    private BrotherRecycleAdapter adapter;


    public static MeetABrotherFragment newInstance() {
        return new MeetABrotherFragment();
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_a_brother, container, false);
        adapter = new BrotherRecycleAdapter((BaseActivity) getActivity(),this);
        brothers = adapter.getBrothers();
        recyclerView =(RecyclerView) view.findViewById(R.id.fragment_meet_a_brother_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.post(new ServiceCalls.SearchBrothersRequest(TauPsiApplication.BROTHER_REFERENCE));
    }

    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }


    @Subscribe
    public void onBrosLoaded(final ServiceCalls.SearchBrothersResponse response){
        int oldBrotherLength = brothers.size();
        if(oldBrotherLength ==0){
            brothers.clear();
            adapter.notifyItemRangeRemoved(0, oldBrotherLength);
            brothers.addAll(response.Brothers);
            adapter.notifyItemRangeChanged(0,brothers.size());
        }
    }


    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent = BrotherPagerActivity.newIntent(getActivity(), brother);
        getContext().startActivity(intent);
    }
}