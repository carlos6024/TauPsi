package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.services.entities.RushEvent;
import com.asutaupsi.taupsi.views.oldViews.RushEventAdapterList;
import com.squareup.otto.Subscribe;




public class RushFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private final String LOG_TAG = RushFragment.class.getSimpleName();
    private ListView listView;
    private RushEventAdapterList adapterList;

    public static RushFragment newInstance(){
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rush, container, false);
        adapterList = new RushEventAdapterList((BaseActivity) getActivity());
        listView = (ListView) view.findViewById(R.id.fragment__rush_list_view);
        View header = inflater.inflate(R.layout.fragment_rush_header,null);
        listView.addHeaderView(header, null, false);
        setUpAdapter();
        listView.setOnItemClickListener(this);
        bus.post(new ServiceCalls.SearchRushEventsRequest("Hello"));
        return view;
    }

    private void setUpAdapter(){
        if(isAdded()){
            listView.setAdapter(adapterList);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //RushEvent event =(RushEvent) listView.getItemAtPosition(position);
        position -= listView.getHeaderViewsCount();
        RushEvent event = adapterList.getItem(position);
        Log.i(LOG_TAG, event.getEventName());
    }


    @Subscribe
    public void onRushEventsLoaded(final ServiceCalls.SearchRushEventsResponse response){
        adapterList.clear();
        adapterList.addAll(response.rushEvents);
        Log.i(LOG_TAG, Integer.toString(adapterList.getCount()) + " Rush Events Found" );
    }
}