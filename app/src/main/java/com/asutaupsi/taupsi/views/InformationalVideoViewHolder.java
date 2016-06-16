package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.squareup.picasso.Picasso;

public class InformationalVideoViewHolder extends RecyclerView.ViewHolder {

    private final TextView videoTitle;
    private final TextView videoAbout;
    private final ImageView videoImageview;

    private  final BaseActivity baseActivity;

    public InformationalVideoViewHolder(View view,BaseActivity baseActivity) {
        super(view);
        videoTitle = (TextView) view.findViewById(R.id.list_informational_video_videoTitle);
        videoAbout = (TextView) view.findViewById(R.id.list_informational_video_videoDesctiption);
        videoImageview = (ImageView) view.findViewById(R.id.list_informational_video_videoImage);
        this.baseActivity = baseActivity;
    }


    public void populate(InformationVideo informationVideo){
        itemView.setTag(informationVideo);
        videoTitle.setText(informationVideo.getVideoTitle());
        videoAbout.setText(informationVideo.getVideoDesctiption());

        Picasso.with(videoImageview.getContext()).load(informationVideo.getVideoImage())
                .into(videoImageview);    }




}
