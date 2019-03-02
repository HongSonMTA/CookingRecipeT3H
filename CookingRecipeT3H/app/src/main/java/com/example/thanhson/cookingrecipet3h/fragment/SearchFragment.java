package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.adapter.PagerAdapterSearch;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentSearchBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.model.entity.KindOffEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.ListDataSearchEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.MenuEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.TypeOfEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class SearchFragment extends Fragment  {
    private static SearchFragment instance;
    private FragmentSearchBinding binding;
    private PagerAdapterSearch adapter;


    public static SearchFragment getInstance() {
        if (instance == null) {
            instance = new SearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        initPager();
        return binding.getRoot();
    }

    private void initPager() {
        adapter = new PagerAdapterSearch(getChildFragmentManager());
        // binding.
        binding.viewPagerSearch.setAdapter(adapter);
        //binding.viewPagerSearch.addOnPageChangeListener(th);
        binding.tabLayoutSearch.setupWithViewPager(binding.viewPagerSearch);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
