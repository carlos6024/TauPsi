package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.asutaupsi.taupsi.services.entities.Brother;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeetABrotherFragment extends BaseFragment {

    private final String LOG_TAG = MeetABrotherFragment.class.getSimpleName();

    @Bind(R.id.fragment_meet_a_brother_imageView)
    ImageView brotherImage;

    @Bind(R.id.fragment_meet_a_brother_name)
    TextView brotherName;

    @Bind(R.id.fragment_meet_a_brother_CrossSemester)
    TextView brotherCrossSemester;

    @Bind(R.id.fragment_meet_a_brother_right)
    ImageButton mbuttonRight;

    @Bind(R.id.fragment_meet_a_brother_left)
    ImageButton mbuttonLeft;

    @Bind(R.id.fragment_meet_a_brother_Major)
    TextView mbrotherMajor;

    @Bind(R.id.fragment_meet_a_brother_about)
    TextView mbrotherAboutParagraph;

    @Bind(R.id.fragment_meet_a_brother_FunFact)
    TextView mbrotherFunFact;

    @Bind(R.id.fragment_meet_a_brother_brother_image_progressBar)
    ProgressBar mbrotherProgressBar;

    public int index;
    public static ArrayList<Brother> brothers;
    public Brother brother;


    public static MeetABrotherFragment newInstance(){
        return new MeetABrotherFragment();
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_a_brother, container, false);
        ButterKnife.bind(this, view);

        brothers = new ArrayList<>();
        bus.post(new ServiceCalls.SearchBrothersRequest("Hello"));

        Collections.shuffle(brothers);
        index = 1;
        UpdateBrotherUI(index);
        return view;
    }


    @OnClick(R.id.fragment_meet_a_brother_left)
    public void clickLeft(){
        if (index ==-1){
            index = brothers.size()-1;}

        if(index == 0){
            index = brothers.size() ;
        }

        index --;

        UpdateBrotherUI(index);

        if(index == 0){
            index = brothers.size() ;
        }

        if(index == brothers.size()-1){
            index = -1 ;
        }
    }


    @OnClick(R.id.fragment_meet_a_brother_right)
    public void clickRight(){

        if(index ==brothers.size()){
            index =0;
        }


        if(index ==brothers.size() -1){
            index =0;
        }

        index ++;

        UpdateBrotherUI(index);

        if(index == brothers.size() -1){
            index = -1 ;
        }


        if(index == 0){
            index = brothers.size();
        }
    }

    @Subscribe
    public void onBrosLoaded(final ServiceCalls.SearchBrothersResponse response){
        brothers.clear();
        brothers.addAll(response.Brothers);
        Log.i(MeetABrotherFragment.class.getSimpleName(),Integer.toString(brothers.size()));
    }




    public void UpdateBrotherUI(int index){
        brother = brothers.get(index);
        Log.i(LOG_TAG, "Brother Updated to " + brother.getBrotherName());

        mbrotherProgressBar.setVisibility(View.VISIBLE);

        Picasso.with(getActivity().getApplicationContext())
                .load(brother.getBrotherPicture()).
                into(brotherImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        mbrotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        brotherName.setText(getString(R.string.brother_name, brother.getBrotherName()));
        brotherCrossSemester.setText(getString(R.string.crossed_intro, brother.getBrotherCrossSemester()));
        mbrotherFunFact.setText(getString(R.string.fun_fact_intro,brother.getBrotherFunFact()));
        mbrotherMajor.setText(getString(R.string.major_intro,brother.getBrotherMajor()));
        mbrotherAboutParagraph.setText(brother.getBrotherAbout());

    }
}


