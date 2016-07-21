package com.asutaupsi.taupsi.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.entities.Brother;

import java.util.ArrayList;

public class BrotherRecycleAdapter extends RecyclerView.Adapter<BrotherViewHolder> implements View.OnClickListener {
    private final LayoutInflater layoutInflater;
    private final BaseActivity activity;
    private final OnBrotherClickedListener listener;
    private final ArrayList<Brother> brothers;


    public BrotherRecycleAdapter(BaseActivity activity, OnBrotherClickedListener listener) {
        this.activity = activity;
        this.listener = listener;
        brothers = new ArrayList<>();
        layoutInflater = activity.getLayoutInflater();
    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }


    @Override
    public BrotherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_brothers_display,parent,false);
        view.setOnClickListener(this);
        return new BrotherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrotherViewHolder holder, int position) {
        holder.populate(brothers.get(position));
    }



    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof Brother){
            Brother brother = (Brother) view.getTag();
            listener.onBrotherClicked(brother);
        }
    }

    public interface OnBrotherClickedListener{
        void onBrotherClicked(Brother brother);
    }
}
