package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class YoutubePlayerActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private String videoUrl;
    public  final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";
    private final int RECOVERY_REQUEST =1;
    private final String YOUTUBE_API_KEY = "Enter your key Here";
    private final String LOG_TAG = YoutubePlayerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 1F;
        setContentView(R.layout.fragment_youtube_player);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(layoutParams);
        videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.fragment_youtube_player_video);
        youTubePlayerView.initialize(YOUTUBE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.loadVideo(videoUrl);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            Log.e(LOG_TAG,errorReason.toString());
        }
    }
}


