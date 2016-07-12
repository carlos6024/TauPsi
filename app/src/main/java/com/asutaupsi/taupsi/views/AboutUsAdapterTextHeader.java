package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AboutUsAdapterTextHeader extends RecyclerView.ViewHolder {
    @Bind(R.id.simple_header_textView)
    TextView simpleHeaderTextView;


    public AboutUsAdapterTextHeader(View view) {
        super(view);
        ButterKnife.bind(this,view);
    }

    public void populate(String text){
        simpleHeaderTextView.setText(text);
    }
}
