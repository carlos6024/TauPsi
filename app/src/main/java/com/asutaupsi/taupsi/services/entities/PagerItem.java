package com.asutaupsi.taupsi.services.entities;

import android.support.v4.app.Fragment;

public class PagerItem {
    private String mTitle;
    private Fragment fragment;

    public PagerItem(String mTitle, Fragment fragment) {
        this.mTitle = mTitle;
        this.fragment = fragment;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
