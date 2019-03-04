package com.example.thanhson.cookingrecipet3h.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.adapter.MakingAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.ResourcesAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentMakingBinding;
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.ImageEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakingFragment extends Fragment {
    private static MakingFragment instance;
    private FragmentMakingBinding binding;
    private String  describeFood;
    private String[] arrMaking;
    private ArrayList<ImageEntity> arrImage;
    private int id;
    private MakingAdapter adapter;

    public static MakingFragment getInstance() {
        if (instance == null) {
            instance = new MakingFragment();
        }
        return instance;
    }
    public void setId(int id) {
        this.id = id;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMakingBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        getData();
        arrMaking = new String['0'];
        arrImage = new ArrayList<>();
        adapter = new MakingAdapter(arrImage,arrMaking,getActivity());
        binding.lvMaking.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvMaking.setAdapter(adapter);
    }
    private void getData() {
        ApiBuilder.builder().getDetailFoods(id).enqueue(new Callback<FoodsEntity>() {
            @Override
            public void onResponse(Call<FoodsEntity> call, Response<FoodsEntity> response) {
                FoodsEntity foodsEntity  = response.body();
                arrMaking = cutData(foodsEntity.getData().getMakingFoods());
                arrImage = foodsEntity.getImages();
                adapter.setArrResources(arrImage,arrMaking);
            }

            @Override
            public void onFailure(Call<FoodsEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private String[] cutData(String data) {
        return data.split("\r\n");
    }

    public void setDescribeFood(String describeFood) {
        this.describeFood = describeFood;
    }
}
