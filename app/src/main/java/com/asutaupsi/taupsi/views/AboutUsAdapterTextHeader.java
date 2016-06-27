package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;


public class AboutUsAdapterTextHeader extends RecyclerView.ViewHolder {
    private final TextView textView;

    public AboutUsAdapterTextHeader(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.simple_header,parent,false));
        textView = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public void populate(String text){
        textView.setText(text);
    }
}
