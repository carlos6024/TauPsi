package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapsActivity extends BaseActivity {


    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private RushEvent rushEvent;
    private final static String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

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
        rushDescription.setText(rushEvent.getEventDescription());
        rushTime.setText(rushEvent.getEventTime());
        rushDate.setText(rushEvent.getEventDate());
        rushLocation.setText(rushEvent.getEventLocation());


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


    private void updateUI() {

        LatLng rushEventPoint = new LatLng(
                    rushEvent.getEventLatitude(), rushEvent.getEventLongitude()
            );

        MarkerOptions rushEventMarker = new MarkerOptions()
                    .position(rushEventPoint)
                    .title("Rush Event Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        mMap.clear();
        mMap.addMarker(rushEventMarker);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint,15));


    }


}



