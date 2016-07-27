package com.asutaupsi.taupsi.views.RushViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RushEventViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_rush_events_name)
    TextView rushEventName;

    @Bind(R.id.list_rush_events_date)
    TextView rushEventDate;

    @Bind(R.id.list_rush_event_location)
    TextView rushEventLocation;

    @Bind(R.id.list_rush_event_time)
    TextView rushEventTime;


    public RushEventViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }


    public void populate(RushEvent rushEvent){
        itemView.setTag(rushEvent);
        rushEventName.setText(rushEvent.getEventName());
        rushEventDate.setText(rushEvent.getEventDate());
        rushEventTime.setText(rushEvent.getEventTime());
        rushEventLocation.setText(rushEvent.getEventLocation());
    }





    }

