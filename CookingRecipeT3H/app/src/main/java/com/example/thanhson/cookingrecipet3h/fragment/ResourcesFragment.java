package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.adapter.FoodsAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.ResourcesAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentResourcesBinding;
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;
import com.example.thanhson.cookingrecipet3h.view.FoodsDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ResourcesFragment extends Fragment {
    private static ResourcesFragment  instance;
    private FragmentResourcesBinding binding;
    private String[] arrResources;
    private String[] arrNumberResource;
    private ResourcesAdapter adapter;
    private int id;

    public static ResourcesFragment getInstance() {
        if (instance == null) {
            instance = new ResourcesFragment();
        }
        return instance;
    }

    public void setId(int id) {
        this.id = id;
    }
    private void initView() {
        getData();
        arrResources = new String['0'];
        arrNumberResource = new String['0'];
        adapter = new ResourcesAdapter(arrResources,arrNumberResource,getActivity());
        binding.lvResources.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvResources.setAdapter(adapter);

    }

    private void getData() {
        ApiBuilder.builder().getDetailFoods(id).enqueue(new Callback<FoodsEntity>() {
            @Override
            public void onResponse(Call<FoodsEntity> call, Response<FoodsEntity> response) {
                FoodsEntity foodsEntity  = response.body();
                arrResources = cutData(foodsEntity.getData().getResources());
                arrNumberResource = cutData(foodsEntity.getData().getNumberResources());
                adapter.setArrResources(arrResources,arrNumberResource);
            }

            @Override
            public void onFailure(Call<FoodsEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResourcesBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }
    private String[] cutData(String data) {
        return data.split(",");
    }
}
