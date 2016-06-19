package com.asutaupsi.taupsi.views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.entities.RushEvent;

import java.util.ArrayList;

public class RushAdapter extends RecyclerView.Adapter<RushViewHolder> implements View.OnClickListener {

    private final LayoutInflater layoutInflater;
    private final BaseActivity activity;
    private final OnRushEventClickListener listener;
    private final ArrayList<RushEvent> rushEvents;


    public RushAdapter(BaseActivity activity,OnRushEventClickListener listener) {
        this.listener = listener;
        this.activity = activity;
        rushEvents = new ArrayList<>();
        layoutInflater = activity.getLayoutInflater();
    }

    public ArrayList<RushEvent> getRushEvents() {
        return rushEvents;
    }



    @Override
    public RushViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_info,parent,false);
        view.setOnClickListener(this);
        RushViewHolder viewHolder = new RushViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RushViewHolder holder, int position) {
        RushEvent rushEvent = rushEvents.get(position);
        holder.populate(activity,rushEvent);
    }

    @Override
    public int getItemCount() {
        return rushEvents.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof RushEvent){
            RushEvent rushEvent = (RushEvent) view.getTag();
            listener.onRushEventClicked(rushEvent);
        }
    }

    public interface OnRushEventClickListener{
        void onRushEventClicked(RushEvent rushEvent);
    }
}
