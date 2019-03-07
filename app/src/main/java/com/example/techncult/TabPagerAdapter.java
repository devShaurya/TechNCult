package com.example.techncult;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList=new ArrayList<>();
    List<String> stringTitle=new ArrayList<>();
    public TabPagerAdapter(FragmentManager fm ) {
        super(fm);

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

    public void addFragment(int position,Fragment fragment,String title){
        fragmentList.add(position,fragment);
        stringTitle.add(position,title);
    }
    public void removeFragment(int pos){
        fragmentList.remove(pos);
        stringTitle.remove(pos);
    }
}
