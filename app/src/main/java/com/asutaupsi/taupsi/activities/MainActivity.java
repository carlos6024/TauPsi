package com.asutaupsi.taupsi.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.views.ViewPagerAdapter;



import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity  {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.activity_main_viewPager)
    ViewPager viewPager;

    @Bind(R.id.activity_tab_layout)
    TabLayout tabLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}








       /* scheduler.invokeEveryMilliseconds(new Runnable() {
            @Override
            public void run() {
                viewPager.getAdapter().notifyDataSetChanged();
                i++;
                Log.i(LOG_TAG,Integer.toString(i));

            }
        },5000,false);

        */
