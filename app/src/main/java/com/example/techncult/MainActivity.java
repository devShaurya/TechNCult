package com.example.techncult;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabPagerAdapter tabPagerAdapter;
    ViewPager viewPager;
    LinearLayout mainlinearLayout;
    TabLayout tabLayout,bottomtabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        bottomtabLayout=findViewById(R.id.tabbottom);
        viewPager=findViewById(R.id.viewPager);
        mainlinearLayout=findViewById(R.id.mainLinearLayout);

        setSupportActionBar(toolbar);
        LinearLayout linearLayout=(LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable=new GradientDrawable();
        drawable.setColor(Color.BLACK);
        drawable.setSize(2,1);
        linearLayout.setDividerDrawable(drawable);
        linearLayout.setDividerPadding(2);

        tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager(),0);
        viewPager.setAdapter(tabPagerAdapter);
        bottomtabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tech=1;
                Log.d("msg",tab.getText().toString());
                if(tab.getText().toString().equals("Technical Council")){
                    tech=0;
                }

                TabPagerAdapter tabPagerAdapter2=new TabPagerAdapter(getSupportFragmentManager(),tech);
                viewPager.setAdapter(tabPagerAdapter2);
                bottomtabLayout.setupWithViewPager(viewPager);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}




