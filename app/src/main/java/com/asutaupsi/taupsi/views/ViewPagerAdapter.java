package com.asutaupsi.taupsi.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.asutaupsi.taupsi.fragments.AboutFragment;
import com.asutaupsi.taupsi.fragments.MeetABrotherFragment;
import com.asutaupsi.taupsi.fragments.RushFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch (position) {
            case 0:
                returnFragment = AboutFragment.newInstance();
                break;
            case 1:
                returnFragment = MeetABrotherFragment.newInstance();
                break;
            case 2:
                returnFragment = RushFragment.newInstance();
                break;
            default:
                return null;
        }
        return returnFragment;
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
