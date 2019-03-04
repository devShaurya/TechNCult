package com.example.techncult;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<String> fragmentTitle;
    public TabPagerAdapter(FragmentManager fm,List<Fragment> fragmentList,
                           List<String> fragmentTitle) {
        super(fm);
        this.fragmentList=fragmentList;
        this.fragmentTitle=fragmentTitle;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
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
