package com.asutaupsi.taupsi.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.activities.BaseActivity;
import com.asutaupsi.taupsi.entities.InformationCard;

import java.util.ArrayList;

public class AboutUsFragmentAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MAIN_HEADER =1;
    private static final int VIEW_TYPE_SERVICE_VIDEOS =2;
    private static final int VIEW_TYPE_ACADEMIC_VIDEOS=3;
    private static final int VIEW_TYPE_SOCIAL_VIDEOS =4;
    private static final int VIEW_TYPE_VIDEO_HEADER = 5;


    private ArrayList<InformationCard> socialCards;
    private ArrayList<InformationCard> brotherhoodCards;
    private ArrayList<InformationCard> communityCards;

    private BaseActivity activity;
    private LayoutInflater inflater;
    private AboutUsListener listener;


    public AboutUsFragmentAdapter(BaseActivity baseActivity, AboutUsListener listener) {
        this.activity = baseActivity;
        this.listener = listener;
        inflater = baseActivity.getLayoutInflater();
        socialCards = new ArrayList<>();
        brotherhoodCards = new ArrayList<>();
        communityCards = new ArrayList<>();
    }

    public ArrayList<InformationCard> getCommunityCards() {
        return communityCards;
    }

    public ArrayList<InformationCard> getBrotherhoodCards() {
        return brotherhoodCards;
    }

    public ArrayList<InformationCard> getSocialCards() {
        return socialCards;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_MAIN_HEADER;
        }

        position --;

        if(communityCards.size()>0){
            if(position ==0){
                return VIEW_TYPE_VIDEO_HEADER;
            }
            position --;

            if(position< communityCards.size()){
                return VIEW_TYPE_SERVICE_VIDEOS;
            }

            position -= communityCards.size();
        }

        if(brotherhoodCards.size()>0){
            if(position ==0){
                return VIEW_TYPE_VIDEO_HEADER;
            }
            position --;

            if(position< brotherhoodCards.size()){
                return VIEW_TYPE_ACADEMIC_VIDEOS;
            }
            position -= brotherhoodCards.size();
        }

        if(socialCards.size()>0){
            if(position ==0){
                return VIEW_TYPE_VIDEO_HEADER;
            }
            position --;

            if(position< socialCards.size()){
                return VIEW_TYPE_SOCIAL_VIDEOS;
            }

            position -= socialCards.size();
        }
        throw  new IllegalArgumentException(
                "we are being asked for an item type from position " + position + ", though we have no such item"
        );

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.list_information_cards,parent,false);
        View rootView2 = inflater.inflate(R.layout.simple_header,parent,false);

        if(viewType == VIEW_TYPE_MAIN_HEADER){
            return  new AboutUsAdapterMainHeader(inflater,parent);
        }

        else if(viewType == VIEW_TYPE_SERVICE_VIDEOS){
            final CommunityServiceHolder serviceHolder = new CommunityServiceHolder(rootView);
            serviceHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InformationCard serviceVideo = (InformationCard) serviceHolder.itemView.getTag();
                    listener.onInformationVideoClicked(serviceVideo);
                }
            });
            return serviceHolder;
        }

        else if(viewType == VIEW_TYPE_ACADEMIC_VIDEOS){
            final BrotherHoodViewHolder academicHolder = new BrotherHoodViewHolder(rootView);
            academicHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InformationCard academicVideo = (InformationCard) academicHolder.itemView.getTag();
                    listener.onInformationVideoClicked(academicVideo);
                }
            });
            return academicHolder;
        }


        else if(viewType == VIEW_TYPE_SOCIAL_VIDEOS) {
            final SocialServiceHolder socialHolder = new SocialServiceHolder(rootView);
            socialHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InformationCard socialVideo = (InformationCard) socialHolder.itemView.getTag();
                    listener.onInformationVideoClicked(socialVideo);
                }
            });
            return socialHolder;
        }

        else if (viewType == VIEW_TYPE_VIDEO_HEADER){
                return new AboutUsAdapterTextHeader(rootView2);
            }

        throw new IllegalArgumentException("ViewType " + viewType + " is not supported");
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        int servicePosition = 1;
        int academicPosition = servicePosition + brotherhoodCards.size() +1 ;
        int socialPosition = academicPosition + socialCards.size()+1;


        if(holder instanceof CommunityServiceHolder){
            position --;
            position --;
            InformationCard serviceVideo = communityCards.get(position);
            holder.itemView.setTag(serviceVideo);
            ((CommunityServiceHolder) holder).populate(activity,serviceVideo);

        } else if(holder instanceof BrotherHoodViewHolder){
            position --;
            position --;
            position --;
            position --;
            position --;
            InformationCard academicVideo = brotherhoodCards.get(position);
            holder.itemView.setTag(academicVideo);
            ((BrotherHoodViewHolder) holder).populate(activity,academicVideo);
        } else if(holder instanceof SocialServiceHolder){
            position --;
            position --;
            position --;
            position --;
            position --;
            position --;
            position --;
            position --;
            InformationCard socialVideo = socialCards.get(position);
            holder.itemView.setTag(socialVideo);
            ((SocialServiceHolder) holder).populate(activity,socialVideo);
        } else if (holder instanceof AboutUsAdapterMainHeader){
            AboutUsAdapterMainHeader header = (AboutUsAdapterMainHeader) holder;
        } else if(holder instanceof AboutUsAdapterTextHeader){
            AboutUsAdapterTextHeader viewHolder = (AboutUsAdapterTextHeader) holder;

            if(position == servicePosition)
            {

                viewHolder.populate("Service");
            }


            if(position == academicPosition)
            {
                viewHolder.populate("Brotherhood");
            }


            if(position == socialPosition)
            {
                viewHolder.populate("Social");
            }


        } else{
            throw new IllegalArgumentException("Cannot populate holder of type " + holder.getClass().getName());
        }
    }

    @Override
    public int getItemCount() {
        int count =1;

        if(communityCards.size() >0){
            count += 1+ communityCards.size();
        }

        if(brotherhoodCards.size()>0){
            count += 1+ brotherhoodCards.size();
        }
        if(socialCards.size()>0){
            count+= 1+ socialCards.size();
        }
        return count;
    }


    public interface AboutUsListener{
        void onInformationVideoClicked(InformationCard video);
    }
}
