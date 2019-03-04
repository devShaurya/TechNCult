package com.example.techncult;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

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
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getText()=="Technical Council"){
                    List<Fragment> fragmentListbottom=new ArrayList<>();
                    fragmentListbottom.add(new Events());
                    fragmentListbottom.add(new Councilinfo());
                    fragmentListbottom.add(new PastEvents());
                    List<String> fragmentTitle=new ArrayList<>();
                    fragmentTitle.add("EVENTS");
                    fragmentTitle.add("Council Info");
                    fragmentTitle.add("Past Events");
                    fragmentTitle.add();
                    tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager(),fragmentListbottom,
                            fragmentTitle);
                    viewPager.setAdapter(tabPagerAdapter);
                    bottomtabLayout.setupWithViewPager(viewPager);
                }else{
                    List<Fragment> fragmentListbottom=new ArrayList<>();
                    fragmentListbottom.add(new Events());
                    fragmentListbottom.add(new Councilinfo());
                    fragmentListbottom.add(new PastEvents());
                    List<String> fragmentTitle=new ArrayList<>();
                    fragmentTitle.add("EVENTS");
                    fragmentTitle.add("Council Info");
                    fragmentTitle.add("Past Events");
                    fragmentTitle.add();
                    tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager(),fragmentListbottom,
                            fragmentTitle);
                    viewPager.setAdapter(tabPagerAdapter);
                    bottomtabLayout.setupWithViewPager(viewPager);

                }

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




