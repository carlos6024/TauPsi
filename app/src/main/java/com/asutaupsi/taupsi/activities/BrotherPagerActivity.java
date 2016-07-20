package com.asutaupsi.taupsi.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.fragments.BrotherDetailsFragment;
import com.asutaupsi.taupsi.services.ServiceCalls;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class BrotherPagerActivity extends BaseActivity {
    private ArrayList<Brother> brothers;
    private ViewPager viewPager;
    private  static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    private  final String LOG_TAG = BrotherPagerActivity.class.getSimpleName();


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
                Brother brother = brothers.get(position);
                return BrotherDetailsFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

    }

    @Subscribe
    public void onBrosLoad(final ServiceCalls.SearchBrothersResponse response){
        brothers.clear();
        brothers.addAll(response.Brothers);
        viewPager.getAdapter().notifyDataSetChanged();
        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();

        for(int i=0;i<brothers.size();i++){
            if(brothers.get(i).getBrotherId() == brotherId){
                viewPager.setCurrentItem(i);
                break;
            }
        }
        Log.i(LOG_TAG, Integer.toString(brothers.size()));
    }


    public static Intent newIntent(Context context, Brother brother){
        Intent intent = new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
