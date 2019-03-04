package com.example.thanhson.cookingrecipet3h.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.thanhson.cookingrecipet3h.fragment.AccountFragment;
import com.example.thanhson.cookingrecipet3h.fragment.CookingFragment;
import com.example.thanhson.cookingrecipet3h.fragment.HomeFragment;
import com.example.thanhson.cookingrecipet3h.fragment.SearchFragment;


public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return HomeFragment.getInstance();
            case 1:
                return CookingFragment.getInstance();
            case 2:
                return SearchFragment.getInstance();
            case 3:
                return AccountFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Cooking";
            case 2:
                return "Search";
            case 3:
                return "Account";
        }
        return super.getPageTitle(position);
    }
}
