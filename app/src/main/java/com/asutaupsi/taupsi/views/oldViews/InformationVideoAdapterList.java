package com.asutaupsi.taupsi.views.oldViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.squareup.picasso.Picasso;


public class InformationVideoAdapterList extends ArrayAdapter<InformationVideo> {
    private LayoutInflater inflater;


    public InformationVideoAdapterList(BaseActivity activity) {
        super(activity,0);
        inflater = activity.getLayoutInflater();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InformationVideo informationVideo = getItem(position);
        InformationalVideoHolder view;


        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_information_videos,parent,false);
            view = new InformationalVideoHolder(convertView);
            convertView.setTag(view);
        } else{
            view = (InformationalVideoHolder) convertView.getTag();
        }

        view.videoTitle.setText(informationVideo.getVideoTitle());
        view.videoAbout.setText(informationVideo.getVideoDesctiption());

        Picasso.with(view.videoImage.getContext()).load(informationVideo.getVideoImage())
                .into(view.videoImage);

        return convertView;

    }


    private class InformationalVideoHolder{
        TextView videoTitle;
        TextView videoAbout;
        ImageView videoImage;


        public InformationalVideoHolder(View view) {
            videoTitle = (TextView) view.findViewById(R.id.list_rush_namefff);
            videoAbout = (TextView) view.findViewById(R.id.list_informational_video_videoDesctiption);
            videoImage = (ImageView) view.findViewById(R.id.list_info_event_name);
        }
    }
}
