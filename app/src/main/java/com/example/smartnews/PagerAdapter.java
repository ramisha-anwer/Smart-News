package com.example.smartnews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
        int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


        switch (position){

            case 0:
                return new Home_fragment();
            case 1:
                return new Sports_fragment();
            case 2:
                return new Health_fragment();
            case 3:
                return new Science_fragment();
            case 4:
                return new Entertainment_fragment();
            case 5:
                return new Tech_fragment();
            default:
                return null;

        }



    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
