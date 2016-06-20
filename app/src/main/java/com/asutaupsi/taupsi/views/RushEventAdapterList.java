package com.asutaupsi.taupsi.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.entities.RushEvent;

public class RushEventAdapterList extends ArrayAdapter<RushEvent>{
    private LayoutInflater inflater;

    public RushEventAdapterList(BaseActivity activity) {
        super(activity, 0);
        inflater = activity.getLayoutInflater();
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RushEvent event = getItem(position);
        ViewHolder view;


        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_rush_events,parent,false);
            view = new ViewHolder(convertView,event);
            convertView.setTag(view);
        } else{
            view = (ViewHolder) convertView.getTag();
        }



        view.rushEventName.setText(event.getEventName());
        view.rushEventDate.setText(event.getEventDate());
        view.rushEventTime.setText(event.getEventTime());
        view.rushEventType.setText(event.getEventType());
        view.rushEventLocation.setText(event.getEventLocation());


        return convertView;
    }



    public interface OnRushEventListener{
        void OnRushEventListener(RushEvent rushEvent);
    }


    private class ViewHolder {
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

        public ViewHolder(View view,RushEvent event){
            rushEventName =(TextView) view.findViewById(R.id.list_rush_events_name);
            rushEventDate = (TextView) view.findViewById(R.id.list_rush_event_date);
            rushEventLocation =(TextView) view.findViewById(R.id.list_rush_event_location);
            rushEventTime = (TextView) view.findViewById(R.id.list_rush_event_time);
            rushEventType = (TextView) view.findViewById(R.id.list_rush_events_type);

        }

    }

}
