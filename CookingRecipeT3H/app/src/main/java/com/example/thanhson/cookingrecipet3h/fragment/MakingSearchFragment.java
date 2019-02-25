package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentMakingSearchBinding;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentTypeSearchBinding;

public class MakingSearchFragment extends Fragment {
    public static MakingSearchFragment instance;

    private FragmentMakingSearchBinding binding;

    public static MakingSearchFragment getInstance() {
        if (instance == null) {
            instance = new MakingSearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMakingSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
