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
import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.MainActivity;
import com.example.thanhson.cookingrecipet3h.adapter.FlipperAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.FoodHorizontalAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.FoodsAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentHomeBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;
import com.example.thanhson.cookingrecipet3h.view.FoodsDetail;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment implements Callback<FoodResponse>,FoodsAdapter.ItemClickCallBack {
    private static HomeFragment  instance;
    private ArrayList<FoodResponse.Foods> arrayFoods ;
    private FoodsAdapter adapter;
    private FragmentHomeBinding binding;
    private ArrayList<FoodResponse.Foods> arrImage = new ArrayList<>();
    private FlipperAdapter flipperAdapter;

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
//        MainActivity activity = (MainActivity) getActivity();
//        activity.getData(adapter);
        arrayFoods = new ArrayList<>();
        adapter = new FoodsAdapter(arrayFoods,getActivity());
        binding.lvFoodHF.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvFoodHF.setAdapter(adapter);


//        binding.viewFlipper.setFlipInterval(2000);
//        binding.viewFlipper.setAutoStart(true);

        adapter.setCallBack(this);
    }
    @Override
    public void onResponse(Call<FoodResponse> call, retrofit2.Response<FoodResponse> response) {
        ArrayList<FoodResponse.Foods> foods = response.body().getArrFoods();
        randomImage(foods);
        flipperAdapter = new FlipperAdapter(getActivity(),arrImage);
        adapter.setArrFoods(foods);

        binding.adapterViewFlipper.setAdapter(flipperAdapter);
        binding.adapterViewFlipper.setFlipInterval(2000);
        binding.adapterViewFlipper.startFlipping();
//        binding..setAdapter(adapter);
//        adapterViewFlipper.setFlipInterval(1000);
//        adapterViewFlipper.startFlipping();
    }

    @Override
    public void onFailure(Call<FoodResponse> call, Throwable t) {

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(),FoodsDetail.class);
        intent.putExtra("ID" ,arrayFoods.get(position).getId());
        startActivity(intent);
    }
    private void randomImage(ArrayList<FoodResponse.Foods> arr){
        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            int index = random.nextInt(arr.size());
            arrImage.add(arr.get(index));
        }
    }
}

