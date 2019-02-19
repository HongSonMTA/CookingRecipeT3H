package com.example.thanhson.cookingrecipet3h.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentCommentBinding;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentDescribeBinding;

public class DescripbeFragment extends Fragment {
    private static DescripbeFragment  instance;
    private FragmentDescribeBinding binding;
    public static DescripbeFragment getInstance() {
        if (instance == null) {
            instance = new DescripbeFragment();
        }
        return instance;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDescribeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
