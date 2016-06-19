package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.services.entities.RushEvent;

public class RushViewHolder extends RecyclerView.ViewHolder {

    //@Bind(R.id.list_rush_events_name)
    private   TextView rushEventName;

    //@Bind(R.id.list_rush_event_date)
    private  TextView rushEventType;




    public RushViewHolder(View view) {
        super(view);
        rushEventName =(TextView) view.findViewById(R.id.list_rush_namefff);
        rushEventType = (TextView) view.findViewById(R.id.list_ruse_type);
    }

    public void populate(Context context,RushEvent rushEvent){
        itemView.setTag(rushEvent);
        rushEventName.setText(rushEvent.getEventName());
        rushEventType.setText(rushEvent.getEventType());
    }
}
