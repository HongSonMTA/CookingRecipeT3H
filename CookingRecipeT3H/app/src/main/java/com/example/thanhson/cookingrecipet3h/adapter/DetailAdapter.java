package com.example.thanhson.cookingrecipet3h.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.thanhson.cookingrecipet3h.fragment.CommentFragment;
import com.example.thanhson.cookingrecipet3h.fragment.MakingFragment;
import com.example.thanhson.cookingrecipet3h.fragment.ResourcesFragment;


public class DetailAdapter extends FragmentPagerAdapter {

    public DetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return MakingFragment.getInstance();
            case 1:
                return ResourcesFragment.getInstance();
            case 2:
                return CommentFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Mô tả";
            case 1:
                return "Nguyên Liệu";
            case 2:
                return "Comment";
        }
        return super.getPageTitle(position);
    }
}
