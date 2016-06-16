package com.asutaupsi.taupsi.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.fragments.AboutFragment;
import com.asutaupsi.taupsi.fragments.MeetABrotherFragment;
import com.asutaupsi.taupsi.fragments.RushFragment;



public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private final AboutFragment aboutFragment = AboutFragment.newInstance();
    private final MeetABrotherFragment meetABrotherFragment = MeetABrotherFragment.newInstance();
    private final RushFragment rushFragment = RushFragment.newInstance();


    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }






    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return aboutFragment;
        } else if(position == 1){
            return meetABrotherFragment;
        } else{
            return rushFragment;
        }
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "About Us";
        } else if(position == 1){
            return "Meet a Bro";
        } else{
            return "Rush";
        }
    }



}
