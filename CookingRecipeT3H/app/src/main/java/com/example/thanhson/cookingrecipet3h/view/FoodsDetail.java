package com.example.thanhson.cookingrecipet3h.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.thanhson.cookingrecipet3h.R;
import com.example.thanhson.cookingrecipet3h.adapter.DetailAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.ActivityDetailBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsDetail extends AppCompatActivity implements ViewPager.OnPageChangeListener, Callback<FoodResponse.Foods> {
    private ActivityDetailBinding binding;
    private DetailAdapter detailAdapter;
    private int id;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Intent intent = this.getIntent();
        id = intent.getIntExtra("ID",-1);
        initView();
    }
    private void initView() {
        getData();
        detailAdapter = new DetailAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(detailAdapter);
        binding.viewPager.addOnPageChangeListener(this);
        binding.layout.setupWithViewPager(binding.viewPager);

    }
    private void getData() {
        ApiBuilder.builder().getDetailFoods(id).enqueue(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onResponse(Call<FoodResponse.Foods> call, Response<FoodResponse.Foods> response) {
      //  ArrayList<FoodResponse.Foods> foods = response.body().get();
    }

    @Override
    public void onFailure(Call<FoodResponse.Foods> call, Throwable t) {

    }
}
