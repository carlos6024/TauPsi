package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.services.entities.InformationVideo;

import java.util.ArrayList;

public class InformationalVideoAdapter extends RecyclerView.Adapter<InformationalVideoViewHolder> implements View.OnClickListener {

    private final LayoutInflater layoutInflater;
    private final BaseActivity activity;
    private final OnInformationalVideoClickListener listener;
    private final ArrayList<InformationVideo> videos;


    public InformationalVideoAdapter(BaseActivity activity, OnInformationalVideoClickListener listener) {
        this.activity = activity;
        this.listener = listener;
        videos = new ArrayList<>();
        layoutInflater = activity.getLayoutInflater();
    }

    public ArrayList<InformationVideo> getVideos() {
        return videos;
    }

    @Override
    public InformationalVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_information_videos,parent);
        view.setOnClickListener(this);
        InformationalVideoViewHolder viewHolder = new InformationalVideoViewHolder(view,activity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InformationalVideoViewHolder holder, int position) {
        holder.populate(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof InformationVideo){
            InformationVideo informationVideo = (InformationVideo) view.getTag();
            listener.onInformationalVideoClickListener(informationVideo);
        }

    }

    public interface OnInformationalVideoClickListener{
        void onInformationalVideoClickListener(InformationVideo informationVideo);
    }

}
