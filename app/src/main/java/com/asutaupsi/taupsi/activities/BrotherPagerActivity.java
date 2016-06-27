package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class BrotherPagerActivity extends BaseActivity {
    private ArrayList<Brother> brothers;
    private ViewPager viewPager;
    private static final String BROTHER_INFO = "BROTHER_INFO";
    private static final String LOG_TAG = BrotherPagerActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        brothers = new ArrayList<>();
        bus.post(new ServiceCalls.SearchBrothersRequest("Hello"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.activity_brother_viewPager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return 0;
            }
        });

    }



    @Subscribe
    public void onBrosLoaded(final ServiceCalls.SearchBrothersResponse response){
        brothers.clear();
        brothers.addAll(response.Brothers);
        Log.i(LOG_TAG, Integer.toString(brothers.size()));
    }
}
