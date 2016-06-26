package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;

public class RushViewHolder extends RecyclerView.ViewHolder {

    //@Bind(R.id.list_rush_events_name)
    TextView rushEventName;

    //@Bind(R.id.list_rush_event_date)
    TextView rushEventDate;

    //@Bind(R.id.list_rush_event_location)
    TextView rushEventLocation;

    //@Bind(R.id.list_rush_event_time)
    TextView rushEventTime;

    //@Bind(R.id.list_rush_events_name_type_layout)
    TextView rushEventType;

    public RushViewHolder(View view){
        super(view);
        rushEventName =(TextView) view.findViewById(R.id.list_rush_events_name);
        rushEventDate = (TextView) view.findViewById(R.id.list_rush_event_date);
        rushEventLocation =(TextView) view.findViewById(R.id.list_rush_event_location);
        rushEventTime = (TextView) view.findViewById(R.id.list_rush_event_time);
        rushEventType = (TextView) view.findViewById(R.id.list_rush_events_type);
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

