package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.entities.RushEvent;

import java.util.ArrayList;

public class RushEventAdapter extends RecyclerView.Adapter {
    private final String LOG_TAG = RushEventAdapter.class.getSimpleName();
    private static final int VIEW_TYPE_RUSH_HEADER = 1;
    private static final int VIEW_RUSH_EVENTS = 2;
    private static final int VIEW_RUSH_FOOTER = 3;


    private ArrayList<RushEvent> rushEvents;

    private BaseActivity activity;
    private LayoutInflater inflater;
    private RushEventListener listener;

    public RushEventAdapter(RushEventListener listener, BaseActivity baseActivity) {
        this.listener = listener;
        this.activity = baseActivity;
        inflater = baseActivity.getLayoutInflater();
        rushEvents = new ArrayList<>();
    }


    public ArrayList<RushEvent> getRushEvents() {
        return rushEvents;
    }


    @Override
    public int getItemViewType(int position) {
        if(position ==0){
            return VIEW_TYPE_RUSH_HEADER;
        }

        position --;

        if(rushEvents.size()>0){

            if(position<rushEvents.size()){
                return VIEW_RUSH_EVENTS;
            }
        }

        position -= rushEvents.size();

        if (position<rushEvents.size()){
            return VIEW_RUSH_FOOTER;
        }
        position --;

        throw new IllegalArgumentException(
                "we are being asked for an item type for position "+ position +", though we have no such item"
        );
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.list_rush_events,parent,false);
        View rootView2 = inflater.inflate(R.layout.header_fragment_rush_,parent,false);
        View rootView3 = inflater.inflate(R.layout.footer_fragment_rush_social_media,parent,false);

        if(viewType == VIEW_TYPE_RUSH_HEADER){
            return new RushHeaderHolder(rootView2);
        }

        else if (viewType == VIEW_RUSH_EVENTS){
            final RushViewHolder rushViewHolder = new RushViewHolder(rootView);
            rushViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RushEvent rushEvent = (RushEvent) rushViewHolder.itemView.getTag();
                    listener.onRushEventClicked(rushEvent);
                }
            });
        return rushViewHolder;
        }

        else if (viewType == VIEW_RUSH_FOOTER){
            return new RushFooterHolder(rootView3);
        }

        throw new IllegalArgumentException("ViewType " + viewType + " is not supported");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof RushHeaderHolder) {
            RushHeaderHolder header = (RushHeaderHolder) holder;
        }

        else if(holder instanceof RushViewHolder){
            position --;
            RushEvent rushEvent = rushEvents.get(position);
            holder.itemView.setTag(rushEvent);
            ((RushViewHolder) holder).populate(activity,rushEvent);
        }  else if (holder instanceof RushFooterHolder){
            RushFooterHolder footer = (RushFooterHolder) holder;
            ((RushFooterHolder) holder).populate(activity);
        }

        else {
            throw new IllegalArgumentException("Cannot populate holder of type " + holder.getClass().getName());
        }
    }

    @Override
    public int getItemCount() {
        int count = 2;

        if (rushEvents.size()>0){
            count += rushEvents.size();
        }

        return count;
    }

    public interface RushEventListener {
        void onRushEventClicked(RushEvent rushEvent);
    }
}
