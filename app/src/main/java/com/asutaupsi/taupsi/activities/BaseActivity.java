package com.asutaupsi.taupsi.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected TauPsiApplication application;
    protected Bus bus;
    private Boolean isRegisteredwithBus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (TauPsiApplication) getApplication();
        bus = application.getBus();
        bus.register(this);
        isRegisteredwithBus = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isRegisteredwithBus) {
            bus.unregister(this);
            isRegisteredwithBus = false;
        }
    }


    public void fadeOut(final SplashActivity.FadeOutListener listner){
        View rootView = findViewById(android.R.id.content);
        rootView.animate()
                .alpha(0)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        listner.onFadeOutEnd();

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .setDuration(100)
                .start();
    }


    public interface FadeOutListener
    {
        void onFadeOutEnd();
    }






}
