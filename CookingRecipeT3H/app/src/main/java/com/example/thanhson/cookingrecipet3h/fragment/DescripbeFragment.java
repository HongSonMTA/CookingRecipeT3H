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
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;
import com.example.thanhson.cookingrecipet3h.view.FoodsDetail;

public class DescripbeFragment extends Fragment {
    private static DescripbeFragment  instance;
    private FragmentDescribeBinding binding;
    private String  describeFood;
    public static DescripbeFragment getInstance() {
        if (instance == null) {
            instance = new DescripbeFragment();
        }
        return instance;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDescribeBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
 //       FoodsDetail detail = (FoodsDetail) getActivity();
//        foodsEntity = detail.getFoodsEntity();
        binding.txtDescribe.setText(describeFood);
    }

    public void setDescribeFood(String describeFood) {
        this.describeFood = describeFood;
    }
}
