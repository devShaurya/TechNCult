package com.example.techncult;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabPagerAdapter tabPagerAdapter;
    ViewPager viewPager;
    CollapsingToolbarLayout collapsingToolbarLayout;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        collapsingToolbarLayout=findViewById(R.id.collapsing);

        tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabPagerAdapter.addFragment(0,new Technical(),"Tech Events");
        tabPagerAdapter.notifyDataSetChanged();
        tabPagerAdapter.addFragment(1,new Cultural(),"Cult Events");
        tabPagerAdapter.notifyDataSetChanged();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.opnDrw, R.string.clsDrw);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        LinearLayout linearLayout=(LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        final GradientDrawable drawable=new GradientDrawable();
        drawable.setColor(Color.BLACK);
        drawable.setSize(2,1);
        linearLayout.setDividerDrawable(drawable);
        linearLayout.setDividerPadding(2);

        try{
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.iitgnjpg);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(@Nullable Palette palette) {
                     int color=palette.getVibrantColor(R.color.colorPrimary);
                     int dark=palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                     collapsingToolbarLayout.setContentScrimColor(color);
                     collapsingToolbarLayout.setStatusBarScrimColor(dark);
                }
            });

        }catch (Exception e){
            Log.d("msg","Failed To create");
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this,R.color.colorPrimary));
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this,R.color.colorPrimaryDark));
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.techcouncil:
                        intent=new Intent(MainActivity.this,CouncilActivity.class);
                        intent.putExtra("Council","Tech Council");
                        startActivity(intent);
                        break;
                    case R.id.cultcouncil:
                        intent=new Intent(MainActivity.this,CouncilActivity.class);
                        intent.putExtra("Council","Cult Council");
                        startActivity(intent);
                        break;
                    case R.id.website:
                        intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iitgn.ac.in/"));
                        startActivity(intent);
                        break;
                    case R.id.notification:
                        intent=new Intent(MainActivity.this,Notification.class);
                        startActivity(intent);
                        break;
                    case R.id.dev:
                        tabPagerAdapter.removeFragment(1);
                        tabPagerAdapter.removeFragment(0);
                        tabPagerAdapter.notifyDataSetChanged();
                        tabPagerAdapter.addFragment(0,new Developers(),"developers");

                        viewPager.setAdapter(tabPagerAdapter);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

}




