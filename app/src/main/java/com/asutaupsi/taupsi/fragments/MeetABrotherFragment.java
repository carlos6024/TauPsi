package com.asutaupsi.taupsi.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.activities.BrotherPagerActivity;
import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.views.BrotherRecycleAdapter;
import com.squareup.otto.Subscribe;


import java.util.ArrayList;

public class MeetABrotherFragment extends BaseFragment implements BrotherRecycleAdapter.OnBrotherClickedListener {

    private final String LOG_TAG = MeetABrotherFragment.class.getSimpleName();

    public static ArrayList<Brother> brothers;
    private RecyclerView recyclerView;
    private BrotherRecycleAdapter adapter;
    private  static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    public static MeetABrotherFragment newInstance() {
        return new MeetABrotherFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_a_brother, container, false);
        adapter = new BrotherRecycleAdapter((BaseActivity) getActivity(),this);
        brothers = adapter.getBrothers();
        recyclerView =(RecyclerView) view.findViewById(R.id.fragment_meet_a_brother_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        setUpAdapter();
        bus.post(new ServiceCalls.SearchBrothersRequest("Hello"));
        return view;
    }




    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }


    @Subscribe
    public void onBrosLoaded(final ServiceCalls.SearchBrothersResponse response){
        int oldBrotherLength = brothers.size();
        brothers.clear();
        adapter.notifyItemRangeRemoved(0, oldBrotherLength);
        brothers.addAll(response.Brothers);

        //Delete for Debug method...
        adapter.notifyItemRangeChanged(0,brothers.size());
        Log.i(LOG_TAG, Integer.toString(brothers.size()));
    }


    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent = newIntent(getActivity(), brother);
        Log.i(LOG_TAG, brother.getBrotherName() + " was Clicked");
        getContext().startActivity(intent);
    }

    public static Intent newIntent(Context context, Brother brother){
        Intent intent = new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO, brother);
        return intent;
    }




}