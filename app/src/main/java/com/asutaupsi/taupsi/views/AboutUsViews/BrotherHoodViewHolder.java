package com.asutaupsi.taupsi.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherHoodViewHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.fragment_brother_details_brotherName)
    TextView videoTitle;

    @Bind(R.id.fragment_brother_details__whyJoined)
    TextView videoAbout;

    @Bind(R.id.fragment_brother_details_ImageView)
    ImageView videoImageview;

    @Bind(R.id.list_information_video_icon)
    ImageView typeImageView;

    @Bind(R.id.fragment_brother_details_progressBar)
    ProgressBar imageProgressBar;


    public BrotherHoodViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,view);
    }


    public void populate(Context context,InformationCard informationVideo){
        itemView.setTag(informationVideo);

        videoTitle.setText(informationVideo.getCardTitle());
        videoAbout.setText(informationVideo.getCardDescription());

        Picasso.with(context).load(informationVideo.getCardImage())
                .fit()
                .centerCrop()
                .into(videoImageview, new Callback() {
                    @Override
                    public void onSuccess() {
                        imageProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        if(!informationVideo.getIsVideo()){
            typeImageView.setImageResource(R.mipmap.camera_icon);
        } else {
            typeImageView.setImageResource(R.mipmap.video_camera);
        }
    }
}
