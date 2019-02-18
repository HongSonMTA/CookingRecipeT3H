package com.example.thanhson.cookingrecipet3h.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhson.cookingrecipet3h.R;
import com.example.thanhson.cookingrecipet3h.databinding.ActivityDetailBinding;

public class FoodsDetail extends AppCompatActivity {
    private ActivityDetailBinding binding;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    }
}
