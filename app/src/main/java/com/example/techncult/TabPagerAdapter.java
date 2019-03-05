package com.example.techncult;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<String> stringTitle;
    public TabPagerAdapter(FragmentManager fm, List<Fragment> fragmentList,
              List<String> stringTitle  ) {
        super(fm);
        this.fragmentList=fragmentList;
        this.stringTitle=stringTitle;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringTitle.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
