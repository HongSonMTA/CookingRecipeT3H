package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentResourcesBinding;


public class ResourcesFragment extends Fragment {
    private static ResourcesFragment  instance;
    private FragmentResourcesBinding binding;
    public static ResourcesFragment getInstance() {
        if (instance == null) {
            instance = new ResourcesFragment();
        }
        return instance;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResourcesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
