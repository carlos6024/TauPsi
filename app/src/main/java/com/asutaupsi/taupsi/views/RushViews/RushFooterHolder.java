package com.asutaupsi.taupsi.views.RushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.YoutubePlayerActivity;
import com.squareup.picasso.Picasso;


import butterknife.Bind;
import butterknife.ButterKnife;

public class RushFooterHolder extends RecyclerView.ViewHolder {

    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";


    @Bind(R.id.footer_fragment_rush_facebookFollow)
    ImageView faceBookImage;

    @Bind(R.id.footer_fragment_rush_InstagramFollow)
    ImageView instagramImage;

    @Bind(R.id.footer_fragment_rush_twitterFollow)
    ImageView twitterImage;

    @Bind(R.id.footer_fragment_rush_snapFollow)
    ImageView snapFollow;

    @Bind(R.id.footer_fragment_rush_rushVideo)
    ImageView rushVideo;



    public RushFooterHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);

        faceBookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100001542042225"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/RushTPO?fref=ts"));
                }
                view.getContext().startActivity(intent);
            }
        });

        snapFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nativeAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://snapchat.com/add/" + "taupsiomega1996"));
                view.getContext().startActivity(nativeAppIntent);
            }
        });

        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=52146950"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/TauPsiOmega"));
                }
                view.getContext().startActivity(intent);

            }
        });

        instagramImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/taupsiomega"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/taupsiomega/"));
                }
                view.getContext().startActivity(intent);

            }
        });


        rushVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), YoutubePlayerActivity.class);
                intent.putExtra(EXTRA_VIDEO_INFO, "xX8SmyfV8S8");
                view.getContext().startActivity(intent);
            }
        });

    }



    public void populate(Context context){
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/faceBookLogo_zps5ehpqnng.png").into(faceBookImage);
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/insta_logo_zpshg6xmz7g.jpg").into(instagramImage);
        Picasso.with(context).load("https://dl.dropboxusercontent.com/s/jbtx0tbvi2t3v67/twitter%20logo.jpg?dl=0").into(twitterImage);
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/snapChat_logo_zpsjzwi8hpr.png").into(snapFollow);
    }
}
