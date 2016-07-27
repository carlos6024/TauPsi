package com.asutaupsi.taupsi.views.BrotherViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_brothers_display_avatar)
    ImageView brotherImage;


    @Bind(R.id.list_brothers_display_progressBar)
    ProgressBar brotherProgressBar;

    public BrotherViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }


    public void populate(Brother brother) {
        itemView.setTag(brother);

        Picasso.with(brotherImage.getContext()).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherImage, new Callback() {
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
