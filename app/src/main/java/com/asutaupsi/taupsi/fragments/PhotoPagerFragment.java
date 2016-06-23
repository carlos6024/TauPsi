package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.fragments.BaseFragment;

public class PhotoPagerFragment extends BaseFragment {
    public static PhotoPagerFragment newInstance(){
        return new PhotoPagerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_view_pager,container,false);
        return view;
    }
}
