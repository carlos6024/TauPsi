package com.asutaupsi.taupsi.views;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.fragments.MeetABrotherFragment;
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


    public void populate(Context context, Brother brother) {
        itemView.setTag(brother);

        Picasso.Builder builder = new Picasso.Builder(context);

        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                Log.i(MeetABrotherFragment.class.getSimpleName(), "Error " + exception.getMessage());
            }
        });

        builder.build().load(brother.getBrotherPicture()).into(brotherImage, new Callback() {
            @Override
            public void onSuccess() {
                brotherProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
/*        Picasso.with(context).load(brother.getBrotherPicture()).into(brotherImage, new Callback() {
            @Override
            public void onSuccess() {
                brotherProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }
    */

    }
}
