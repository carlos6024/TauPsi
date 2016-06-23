package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.widget.ImageView;

import com.asutaupsi.taupsi.R;
import com.squareup.picasso.Picasso;

public class PhotoPagerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_photo_view_pager);
        ImageView imageView =(ImageView) findViewById(R.id.fragment_pager_example);

        Picasso.with(getApplicationContext()).load("http://www.gravatar.com/avatar/" + 1 + "?d=identicon")
                .into(imageView);
    }
}
