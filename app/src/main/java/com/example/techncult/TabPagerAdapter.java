package com.example.techncult;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tech Events";
            case 1:
                return  "Cultural Events";
        }
        return null;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new Technical();
            case 1:
                return new Cultural();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
