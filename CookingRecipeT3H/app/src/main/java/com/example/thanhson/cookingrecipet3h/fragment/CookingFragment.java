package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentCookingBinding;

public class CookingFragment extends Fragment {
    private static CookingFragment  instance;
    private FragmentCookingBinding binding;
    public static CookingFragment getInstance() {
        if (instance == null) {
            instance = new CookingFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCookingBinding.inflate(inflater,container,false);
        //binding.tx
        return binding.getRoot();
    }
}
