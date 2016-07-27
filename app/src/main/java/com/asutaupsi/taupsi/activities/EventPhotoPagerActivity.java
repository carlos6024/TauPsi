package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.asutaupsi.taupsi.fragments.EventPhotoFragment;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class EventPhotoPagerActivity extends BaseActivity {

    ArrayList<EventPhoto> mEventPhotos;

    private ViewPager mViewPager;
    private final String LOG_TAG = EventPhotoPagerActivity.class.getSimpleName();
    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_event);
        mEventPhotos = new ArrayList<>();
        InformationCard informationCard = getIntent().getParcelableExtra(EXTRA_VIDEO_INFO);

        Log.i(LOG_TAG, "Event Photo Pager Activity called");
        Log.i(LOG_TAG,Integer.toString(informationCard.getCardId()) + " Card id");

        int CardPosition = informationCard.getCardId();
        switch (CardPosition){
            case 1:
                bus.post(new ServiceCalls.SearchBeALeaderPhotosRequest("Search Param"));
                Log.i(LOG_TAG, "BE a leader photos requested");
                break;
            case 3:
                bus.post(new ServiceCalls.SearchTravelingPhotosRequest("Search Param"));
                break;

            case 5:
                bus.post(new ServiceCalls.SearchSexyShowCaseRequest("Search Param"));
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager = (ViewPager) findViewById(R.id.activity_photo_event_viewPager);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                EventPhoto eventPhoto = mEventPhotos.get(position);
                return EventPhotoFragment.newInstance(eventPhoto);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });
    }



    @Subscribe
    public void getServicePhotos(ServiceCalls.SearchBeALeaderPhotosResponse response) {
        mEventPhotos.clear();
        mEventPhotos.addAll(response.BeALeaderPhotos);
        mViewPager.getAdapter().notifyDataSetChanged();
        Log.i(LOG_TAG, Integer.toString(mEventPhotos.size()) + " service photos added from otto");
    }


    @Subscribe
    public void getTravelingPhotos(ServiceCalls.SearchTravelingPhotosResponse response) {
        mEventPhotos.clear();
        mEventPhotos.addAll(response.TravelingEventPhotos);
        mViewPager.getAdapter().notifyDataSetChanged();
        Log.i(LOG_TAG, Integer.toString(mEventPhotos.size()) + " traveling photos added from otto");
    }


    @Subscribe
    public void getSecyShowCasePhotos(ServiceCalls.SearchSexyShowcaseResponse response) {
        mEventPhotos.clear();
        mEventPhotos.addAll(response.SexyShowCasePhotos);
        mViewPager.getAdapter().notifyDataSetChanged();
        Log.i(LOG_TAG,Integer.toString(mEventPhotos.size()) + " sexy show case photos added from otto");
    }
}
