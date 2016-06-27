package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BrotherViewHolder extends RecyclerView.ViewHolder {

    private ImageView brotherImage;
    private ProgressBar brotherProgressBar;

    public BrotherViewHolder(View view) {
        super(view);
        brotherImage = (ImageView) view.findViewById(R.id.list_brothers_display_avatar);
        brotherProgressBar = (ProgressBar) view.findViewById(R.id.list_brothers_display_progressBar);
    }


    public void populate(Context context, Brother brother){
        itemView.setTag(brother);

        Picasso.with(context).load(brother.getBrotherPicture()).into(brotherImage, new Callback() {
            @Override
            public void onSuccess() {
                brotherProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }
}
