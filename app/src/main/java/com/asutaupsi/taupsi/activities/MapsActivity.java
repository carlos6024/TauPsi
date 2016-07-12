package com.asutaupsi.taupsi.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapsActivity extends BaseActivity {


    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private Location locationCurrent;
    private RushEvent rushEvent;
    private final static String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";
    private final static String LOG_TAG = MapsActivity.class.getSimpleName();

    @Bind(R.id.activity_map_rushName)
    TextView rushName;

    @Bind(R.id.activity_maps_rushTime)
    TextView rushTime;


    @Bind(R.id.activity_maps_rushDate)
    TextView rushDate;

    @Bind(R.id.activity_maps_rushLocation)
    TextView rushLocation;


    @Bind(R.id.activity_maps_rushDescripton)
    TextView rushDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushName.setText(rushEvent.getEventName());
        rushDescription.setText(rushEvent.getEventDiscription());
        rushTime.setText(rushEvent.getEventTime());
        rushDate.setText(rushEvent.getEventDate());
        rushLocation.setText(rushEvent.getEventLocation());



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    0);
        }

        mClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mClient.disconnect();
    }





    private void updateUI(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            Log.i(LOG_TAG, "Connected ");

            locationCurrent = LocationServices.FusedLocationApi.getLastLocation(mClient);

            LatLng userPoint = new LatLng(
                    locationCurrent.getLatitude(), locationCurrent.getLongitude()
            );

            LatLng rushEventPoint = new LatLng(
                    rushEvent.getEventLatitude(),rushEvent.getEventLongitude()
            );



            MarkerOptions userLocationMarker = new MarkerOptions()
                    .position(userPoint)
                    .title("Your Location");


            MarkerOptions rushEventMarker = new MarkerOptions()
                    .position(rushEventPoint)
                    .title("Rush Event Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

            mMap.clear();
            mMap.addMarker(userLocationMarker);
            mMap.addMarker(rushEventMarker);


            LatLngBounds bounds = new LatLngBounds.Builder()
                    .include(rushEventPoint)
                    .include(userPoint)
                    .build();

            int margin = getResources().getDimensionPixelSize(R.dimen.map_inset_margin);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, margin);
            mMap.animateCamera(cameraUpdate);
        } else{
            Log.i(LOG_TAG,"Permisson not yet grandted");
        }

    }


}



