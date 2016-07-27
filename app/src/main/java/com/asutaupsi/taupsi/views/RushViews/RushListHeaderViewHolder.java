package com.asutaupsi.taupsi.views.RushViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;

public class RushListHeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView header_title;
    public ImageView buttonToggle;
    public Item referralItem;
    public View backgroundView;

    public RushListHeaderViewHolder(View itemView) {
        super(itemView);
        header_title = (TextView) itemView.findViewById(R.id.header_title);
        buttonToggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        backgroundView = itemView.findViewById(R.id.list_header_background);
    }
}