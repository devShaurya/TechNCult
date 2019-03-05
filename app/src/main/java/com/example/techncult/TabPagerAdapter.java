package com.example.techncult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    int tech;

    public TabPagerAdapter(FragmentManager fm,int tech) {
        super(fm);
        this.tech=tech;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "EVENTS";
            case 1:
                return "Council Info";
            case 2:
                return "Past Events";
            case 3:
                return "Important";
        }

        return null;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle=new Bundle();
        bundle.putInt("tech",tech);
        switch (i){
            case 0:
                Events events=new Events();

                events.setArguments(bundle);
                return events;
            case 1:
                Councilinfo councilinfo=new Councilinfo();

                councilinfo.setArguments(bundle);
                return councilinfo;
            case 2:
                PastEvents pastEvents=new PastEvents();

                pastEvents.setArguments(bundle);
                return pastEvents;
            case 3:
                return new Important();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
