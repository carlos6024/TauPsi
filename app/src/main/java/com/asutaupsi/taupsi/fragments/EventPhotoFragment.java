package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.EventPhoto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventPhotoFragment extends BaseFragment {

    @Bind(R.id.fragment_event_photoView)
    ImageView eventPhotoView;

    @Bind(R.id.fragment_event_photoProgressBar)
    ProgressBar eventPhotoProgressBar;

    private EventPhoto eventPhoto;

    private final static String EVENT_PHOTO = "EVENT_PHOTO";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventPhoto = getArguments().getParcelable(EVENT_PHOTO);


    }


    public static EventPhotoFragment newInstance(EventPhoto eventPhoto){
        Bundle arguments = new Bundle();
        arguments.putParcelable(EVENT_PHOTO, eventPhoto);
        EventPhotoFragment eventPhotoFragment = new EventPhotoFragment();
        eventPhotoFragment.setArguments(arguments);
        return eventPhotoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_photos,container,false);
        ButterKnife.bind(this, rootView);
        eventPhotoProgressBar.setVisibility(View.VISIBLE);
        Picasso.with(getActivity()).load(eventPhoto.getEventPhotoUrl())
                .fit()
                .centerCrop()
                .into(eventPhotoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventPhotoProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;
    }
}
