package com.example.techncult;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabPagerAdapter tabPagerAdapter;
    ViewPager viewPager;
    LinearLayout mainlinearLayout;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        mainlinearLayout=findViewById(R.id.mainLinearLayout);

        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        LinearLayout linearLayout=(LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable=new GradientDrawable();
        drawable.setColor(Color.BLACK);
        drawable.setSize(2,1);
        linearLayout.setDividerDrawable(drawable);
        linearLayout.setDividerPadding(2);
    }
}




