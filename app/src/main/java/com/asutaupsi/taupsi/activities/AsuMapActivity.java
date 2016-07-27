package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.RushEvent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AsuMapActivity extends BaseActivity {

    @Bind(R.id.activity_asu_map_webView)
    WebView asuWebView;

    @Bind(R.id.activity_asu_map_rushName)
    TextView rushEventName;

    @Bind(R.id.activity_asu_map_rushLocation)
    TextView rushEventLocation;

    @Bind(R.id.activity_asu_map_rushTime)
    TextView rushEventTime;

    @Bind(R.id.activity_asu_map_rushDescription)
    TextView rushDescription;

    @Bind(R.id.activity_asu_map_ProgressBar)
    ProgressBar asuMapProgressBar;


    @Bind(R.id.activity_asu_map_rushDate)
    TextView rushDate;

    private String link;

    private final static String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";
    private final String LOG_TAG = AsuMapActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asu_map);
        ButterKnife.bind(this);
        RushEvent rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushEventName.setText(rushEvent.getEventName());
        rushDescription.setText(rushEvent.getEventDescription());
        rushEventLocation.setText(rushEvent.getEventLocation());
        rushEventTime.setText(rushEvent.getEventTime());
        rushDate.setText(rushEvent.getEventDate());
        String googleDocs = "http://docs.google.com/gview?embedded=true&url=";

        if(!rushEvent.isDowntown()){
            link = "http://www.asu.edu/map/pdf/asu_map_tempe_2015.pdf";
        } else {
            link = "https://www.asu.edu/map/pdf/asu_map_dwntwnphx_2014.pdf";
        }

        asuMapProgressBar.setMax(100);


        asuWebView.getSettings().setJavaScriptEnabled(true);
        asuWebView.getSettings().setDomStorageEnabled(true);
        asuWebView.getSettings().setBuiltInZoomControls(true);
        asuWebView.getSettings().setSupportZoom(true);


        asuWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    asuMapProgressBar.setVisibility(View.GONE);
                } else {
                    asuMapProgressBar.setVisibility(View.VISIBLE);
                    asuMapProgressBar.setProgress(newProgress);
                }
            }
        });
        asuWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

        });

        Log.i(LOG_TAG,link);
        asuWebView.loadUrl(googleDocs + link);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && asuWebView.canGoBack()){
            asuWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}





