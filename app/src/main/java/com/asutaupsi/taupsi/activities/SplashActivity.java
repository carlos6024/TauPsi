package com.asutaupsi.taupsi.activities;


import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nextActivity();
    }

    private void nextActivity(){
        Intent intent = new Intent(this, PracticeActiviy.class);
        startActivity(intent);
        finish();
    }

}




