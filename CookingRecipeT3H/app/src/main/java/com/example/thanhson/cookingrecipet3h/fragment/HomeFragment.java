package com.example.thanhson.cookingrecipet3h.fragment;


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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.adapter.FoodAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.FoodHorizontalAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentHomeBinding;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.networking.CallAPI;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements FoodAdapter.ItemClickCallBack {
    private static HomeFragment  instance;
    private ArrayList<Foods> arrayFoods =new ArrayList<>();
    private FoodAdapter adapter;
    private FoodHorizontalAdapter foodHorizontalAdapter;
    private CallAPI callAPI;
    private String urlDataFoods = "https://congthucnauanst.000webhostapp.com/connect/getDataFoods.php";

    private FragmentHomeBinding binding;

    public static HomeFragment getInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }
    public ArrayList<Foods> getData() {
        final  ArrayList<Foods> arrayList = new ArrayList<>();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlDataFoods, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String ten = jsonObject.getString("name");
                        String trangThai = jsonObject.getString("status");
                        String nguon = jsonObject.getString("origin_foods");
                        String nguyenlieu = jsonObject.getString("resources");
                        String slgnl = jsonObject.getString("number_resources");
                        String cachLam = jsonObject.getString("making_foods");
                        String moTa = jsonObject.getString("describe_foods");
                        String image = jsonObject.getString("image");
                        String time = jsonObject.getString("time");

                        arrayList.add(new Foods(id, ten, time, nguyenlieu, image, moTa, cachLam, slgnl, nguon, trangThai));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
                foodHorizontalAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
        return arrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
       // getData(urlDataFoods);
        initView();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        arrayFoods = getData();
        adapter = new FoodAdapter(getContext());
        foodHorizontalAdapter = new FoodHorizontalAdapter(getContext());
        adapter.setFoods(arrayFoods);
        foodHorizontalAdapter.setFoods(arrayFoods);
        binding.lvFoodHF.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.lvFoodHF.setAdapter(foodHorizontalAdapter);
        binding.lvFoodHORIZONTAL.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvFoodHORIZONTAL.setAdapter(adapter);
        adapter.setCallBack(this);
    }
    @Override
    public void onClick(int position) { ;
    }
}

