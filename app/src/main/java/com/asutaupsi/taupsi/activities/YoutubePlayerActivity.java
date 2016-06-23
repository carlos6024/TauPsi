package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.services.entities.InformationCard;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;


public class YoutubePlayerActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayer myouTubePlayer;
    private YouTubePlayerView youTubePlayerView;
    private InformationCard video;
    private YouTubePlayerFragment youTubePlayerFragment;
    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";
    private final int RECOVERY_REQUEST =1;
    private final String YOUTUBE_API_KEY = "";
    private final String LOG_TAG = YoutubePlayerActivity.class.getSimpleName();
    private MyPlayerStateChangeListener myPlayerStateChangeListener;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

       /* WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -20;
        params.height = 100;
        params.width = 550;
        params.y = -10;
        this.getWindow().setAttributes(params);
        */

        //DisplayMetrics metrics = getResources().getDisplayMetrics();
        //int screenWidth = (int)(metrics.widthPixels *0.80);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 1F;
        setContentView(R.layout.fragment_youtube_player);
        getWindow().setAttributes(layoutParams);
        //getWindow().setLayout(screenWidth, WindowManager.LayoutParams.WRAP_CONTENT);
        video = getIntent().getParcelableExtra(EXTRA_VIDEO_INFO);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.fragment_youtube_player_video);
        youTubePlayerView.initialize(YOUTUBE_API_KEY, this);
        myPlayerStateChangeListener = new MyPlayerStateChangeListener();

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        YouTubePlayer.PlayerStyle style = YouTubePlayer.PlayerStyle.MINIMAL;
        youTubePlayer.setPlayerStyle(style);
        myouTubePlayer = youTubePlayer;
        myouTubePlayer.setPlayerStateChangeListener(myPlayerStateChangeListener);
        youTubePlayer.loadVideo(video.getVideoYoutubeEnding());
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            Log.e(LOG_TAG,errorReason.toString());
        }
    }


    private final class MyPlayerStateChangeListener implements
            YouTubePlayer.PlayerStateChangeListener {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(
                com.google.android.youtube.player.YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
            finish();
        }
        @Override
        public void onVideoStarted() {
        }
    }
}


