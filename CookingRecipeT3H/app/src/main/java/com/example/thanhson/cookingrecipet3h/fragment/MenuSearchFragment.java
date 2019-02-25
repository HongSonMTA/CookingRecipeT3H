package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentMenuSearchBinding;

public class MenuSearchFragment extends Fragment {
    public static MenuSearchFragment instance;

    private FragmentMenuSearchBinding binding;

    public static MenuSearchFragment getInstance() {
        if (instance == null) {
            instance = new MenuSearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
