package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.squareup.picasso.Picasso;

public class CommunityServiceViewHolder extends RecyclerView.ViewHolder {
    private final TextView videoTitle;
    private final TextView videoAbout;
    private final ImageView videoImageview;
    private final ImageView typeImageView;

    public CommunityServiceViewHolder(View view) {
        super(view);
        videoTitle = (TextView) view.findViewById(R.id.list_informational_video_title_name);
        videoAbout = (TextView) view.findViewById(R.id.list_informational_video_videoDescription);
        videoImageview = (ImageView) view.findViewById(R.id.list_information_video_videoImage);
        typeImageView = (ImageView) view.findViewById(R.id.list_information_video_icon);

    }


    public void populate(Context context,InformationCard informationVideo){
        itemView.setTag(informationVideo);

        videoTitle.setText(informationVideo.getVideoTitle());
        videoAbout.setText(informationVideo.getVideoDescription());

        Picasso.with(context).load(informationVideo.getVideoImage())
                .into(videoImageview);


        if(!informationVideo.getIsVideo()){
            typeImageView.setImageResource(R.mipmap.camer_icon);
        } else {
            typeImageView.setImageResource(R.mipmap.video_icon);
        }
    }

}
