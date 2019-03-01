package com.example.thanhson.cookingrecipet3h.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.R;
import com.example.thanhson.cookingrecipet3h.adapter.DetailAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.ActivityDetailBinding;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentCommentBinding;
import com.example.thanhson.cookingrecipet3h.fragment.CommentFragment;
import com.example.thanhson.cookingrecipet3h.fragment.DescripbeFragment;
import com.example.thanhson.cookingrecipet3h.fragment.ResourcesFragment;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsDetail extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ActivityDetailBinding binding;
    private DetailAdapter detailAdapter;
    private int id;
    private FoodsEntity foodsEntity = new FoodsEntity();
    private ActionBar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        toolbar = getSupportActionBar();
        toolbar.hide();
        Intent intent = this.getIntent();
        id = intent.getIntExtra("ID", 0);
        ResourcesFragment.getInstance().setId(id);
        CommentFragment.getInstance().setId(id);
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
        ApiBuilder.builder().getDetailFoods(id).enqueue(new Callback<FoodsEntity>() {
            @Override
            public void onResponse(Call<FoodsEntity> call, Response<FoodsEntity> response) {
                foodsEntity  = response.body();
                DescripbeFragment.getInstance().setDescribeFood(foodsEntity.getData().getDescribeFoods());
                Glide.with(FoodsDetail.this)
                        .load(foodsEntity.getData().getImage())
                        .into(binding.txtImFood);
                binding.txtNamedetail.setText(foodsEntity.getData().getName());
                binding.txtTimedetail.setText(foodsEntity.getData().getTime()+ " Phút ");
                binding.txtStatusdetail.setText(foodsEntity.getData().getStatusFoods());
            }

            @Override
            public void onFailure(Call<FoodsEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
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

    public void setFoodsEntity(FoodsEntity foodsEntity) {
        this.foodsEntity = foodsEntity;
    }

}
