package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RushViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_rush_events_name)
    TextView rushEventName;

    @Bind(R.id.list_rush_event_date)
    TextView rushEventDate;

    @Bind(R.id.list_rush_event_location)
    TextView rushEventLocation;

    @Bind(R.id.list_rush_event_time)
    TextView rushEventTime;

    @Bind(R.id.list_rush_events_type)
    TextView rushEventType;

    public RushViewHolder(View view){
        super(view);
        ButterKnife.bind(this,view);
    }



    public void populate(Context context, RushEvent rushEvent){
        itemView.setTag(rushEvent);
        rushEventName.setText(rushEvent.getEventName());
        rushEventDate.setText(rushEvent.getEventDate());
        rushEventTime.setText(rushEvent.getEventTime());
        rushEventType.setText(rushEvent.getEventType());
        rushEventLocation.setText(rushEvent.getEventLocation());

    }





    }

