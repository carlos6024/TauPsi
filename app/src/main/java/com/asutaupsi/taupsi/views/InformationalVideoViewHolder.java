package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.squareup.picasso.Picasso;

public class InformationalVideoViewHolder extends RecyclerView.ViewHolder {

    private final TextView videoTitle;
    private final TextView videoAbout;
    private final ImageView videoImageview;

    public InformationalVideoViewHolder(View view) {
        super(view);
        videoTitle = (TextView) view.findViewById(R.id.list_rush_namefff);
        videoAbout = (TextView) view.findViewById(R.id.list_informational_video_videoDesctiption);
        videoImageview = (ImageView) view.findViewById(R.id.list_info_event_name);
    }


    public void populate(Context context,InformationVideo informationVideo){
        itemView.setTag(informationVideo);

        videoTitle.setText(informationVideo.getVideoTitle());
        videoAbout.setText(informationVideo.getVideoDesctiption());

        Picasso.with(context).load(informationVideo.getVideoImage())
                .into(videoImageview);
    }

}
