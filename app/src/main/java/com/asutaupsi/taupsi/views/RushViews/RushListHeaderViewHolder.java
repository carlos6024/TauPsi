package com.asutaupsi.taupsi.views.RushViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RushListHeaderViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.header_title)
    TextView header_title;

    @Bind(R.id.btn_expand_toggle)
    ImageView buttonToggle;

    @Bind(R.id.list_header_background)
    View backgroundView;

    public Item referralItem;

    public RushListHeaderViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,view);
    }
}