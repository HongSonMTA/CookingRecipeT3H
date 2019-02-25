package com.example.thanhson.cookingrecipet3h.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.thanhson.cookingrecipet3h.fragment.MakingSearchFragment;
import com.example.thanhson.cookingrecipet3h.fragment.MenuSearchFragment;
import com.example.thanhson.cookingrecipet3h.fragment.TypeSearchFragment;

public class PagerAdapterSearch extends FragmentPagerAdapter {
    public PagerAdapterSearch(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return MenuSearchFragment.getInstance();
            case 1:
                return TypeSearchFragment.getInstance();
            case 2:
                return MakingSearchFragment.getInstance();
        }
        return null;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Thực đơn";
            case 1:
                return "Loại món";
            case 2:
                return "Cách nấu";

        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
