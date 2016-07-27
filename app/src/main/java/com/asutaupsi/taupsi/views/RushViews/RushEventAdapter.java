package com.asutaupsi.taupsi.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.entities.RushEvent;

import java.util.ArrayList;
import java.util.List;

public class RushEventAdapter extends RecyclerView.Adapter {

    private static final int LIST_HEADER = 1;
    public static final int HEADER =2;
    public static final int CHILD =3;
    private static final int LIST_FOOTER = 4;

    private List<Item> data;
    private BaseActivity activity;
    private LayoutInflater inflater;
    private RushEventListener listener;

    public RushEventAdapter(BaseActivity baseActivity,RushEventListener listener) {
        this.listener = listener;
        this.activity = baseActivity;
        inflater = baseActivity.getLayoutInflater();
        data = new ArrayList<>();
    }

    public List<Item> getData() {
        return data;
    }



    @Override
    public int getItemViewType(int position) {
        if(position ==0){
            return LIST_HEADER;
        }

        position --;


        if(position<data.size()){
                return data.get(position).type;
            }


        position -= data.size();


        if(position<data.size()){
            return LIST_FOOTER;
        }

        position --;


        throw new IllegalArgumentException(
                "we are being asked for an item type for position "+ position +", though we have no such item"
        );

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View rootView = inflater.inflate(R.layout.list_rush_expandable_header,parent,false);
        View rootView2 = inflater.inflate(R.layout.list_rush_events,parent,false);
        View rootView3 = inflater.inflate(R.layout.header_fragment_rush_,parent,false);
        View rootView4 = inflater.inflate(R.layout.footer_fragment_rush_social_media,parent,false);

        switch(type){
            case HEADER:
                return new RushListHeaderViewHolder(rootView);

            case CHILD:
                final RushEventViewHolder holder = new RushEventViewHolder(rootView2);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent rushEvent = (RushEvent) holder.itemView.getTag();
                        listener.onRushEventClicked(rushEvent);
                    }
                });
                return holder;

            case LIST_HEADER:
                return new RushHeaderHolder(rootView3);

            case LIST_FOOTER:
                return new RushFooterHolder(rootView4);

        }

        throw new IllegalArgumentException("ViewType " + type + " is not supported");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RushListHeaderViewHolder) {
            position --;
            final Item item = data.get(position);


            final RushListHeaderViewHolder itemController = (RushListHeaderViewHolder) holder;
            itemController.referralItem = item;
            itemController.header_title.setText(item.text);

            if(item.invisibleChildren ==null){
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            } else{
                itemController.buttonToggle.setImageResource(R.mipmap.plus);
            }


            itemController.backgroundView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(item.invisibleChildren ==null){
                        item.invisibleChildren = new ArrayList<>();
                        int count = 0;
                        int position = data.indexOf(itemController.referralItem);
                        while(data.size()> position +1 && data.get(position +1).type ==CHILD){
                            item.invisibleChildren.add(data.remove(position +1));
                            count ++;
                        }
                        notifyItemRangeRemoved(position +1, count);
                        itemController.buttonToggle.setImageResource(R.mipmap.plus);

                    } else{
                        int position = data.indexOf(itemController.referralItem);
                        int index = position +1;
                        for (Item item1: item.invisibleChildren){
                            data.add(index,item1);
                            index ++;
                        }
                        notifyItemRangeInserted(position + 1, index - position - 1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        item.invisibleChildren = null;

                    }
                }
            });

        } else if (holder instanceof  RushEventViewHolder) {
            position --;
            RushEventViewHolder holder1 = (RushEventViewHolder) holder;
            holder1.populate(data.get(position).rushEvent);
        } else if (holder instanceof RushHeaderHolder) {
            RushHeaderHolder headerHolder = (RushHeaderHolder) holder;
        } else if(holder instanceof RushFooterHolder){
            ((RushFooterHolder) holder).populate(activity);
        }
    }



    @Override
    public int getItemCount() {
        int count = 2;

        if (data.size()>0){
            count += data.size();
        }

        return count;
    }


    public interface RushEventListener {
        void onRushEventClicked(RushEvent rushEvent);
    }
}
