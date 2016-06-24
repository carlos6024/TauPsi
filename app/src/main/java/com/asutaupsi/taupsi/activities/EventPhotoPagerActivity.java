package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.fragments.EventPhotoFragment;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class EventPhotoPagerActivity extends BaseActivity {

    ArrayList<EventPhoto> mEventPhotos;
    private ViewPager mViewPager;
    private final String LOG_TAG = EventPhotoPagerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_event);

        mEventPhotos = new ArrayList<>();
        bus.post(new ServiceCalls.SearchFormalPhotosRequest("Search Param"));
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
    public void getFormalPhotos(ServiceCalls.SearchFormalPhotosResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.FormalEventPhotos);
        Log.i(LOG_TAG,Integer.toString(mEventPhotos.size()) + " formal photos added from otto");
    }



}
