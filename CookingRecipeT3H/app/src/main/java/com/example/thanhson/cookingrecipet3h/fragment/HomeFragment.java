package com.example.thanhson.cookingrecipet3h.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.adapter.FoodHorizontalAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.FoodsAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentHomeBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment implements Callback<FoodResponse> {
    private static HomeFragment  instance;
    private ArrayList<Foods> arrayFoods =new ArrayList<>();
    private FoodsAdapter adapter;
    private FoodHorizontalAdapter foodHorizontalAdapter;
    private FragmentHomeBinding binding;

    public static HomeFragment getInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }
    private void getData() {
        ApiBuilder.builder().getFoods().enqueue(this);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        getData();
        arrayFoods = new ArrayList<>();
        adapter = new FoodsAdapter(getActivity());
        foodHorizontalAdapter = new FoodHorizontalAdapter(getContext());
        binding.lvFoodHORIZONTAL.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.lvFoodHORIZONTAL.setAdapter(foodHorizontalAdapter);
        binding.lvFoodHF.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvFoodHF.setAdapter(adapter);

      //  adapter.setCallBack(this);
    }
    @Override
    public void onResponse(Call<FoodResponse> call, retrofit2.Response<FoodResponse> response) {
        ArrayList<FoodResponse.Foods> foods = response.body().getArrFoods();
        adapter.setArrFoods(foods);
        foodHorizontalAdapter.setArrFoods(foods);
    }

    @Override
    public void onFailure(Call<FoodResponse> call, Throwable t) {

    }
}

