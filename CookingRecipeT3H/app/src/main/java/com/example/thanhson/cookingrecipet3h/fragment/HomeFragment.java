package com.example.thanhson.cookingrecipet3h.fragment;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.thanhson.cookingrecipet3h.databinding.FragmentHomeBinding;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.networking.CallAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements FoodAdapter.ItemClickCallBack {
    private static HomeFragment  instance;
    private ArrayList<Foods> arrayFoods =new ArrayList<>();
    private FoodAdapter adapter;
    private CallAPI callAPI;
    private String urlDataFoods = "https://congthucnauanst.000webhostapp.com/connect/getDataFoods.php";

    private FragmentHomeBinding binding;

    public static HomeFragment getInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }
    public ArrayList<Foods> getData(String urlDataFoods) {
      final ArrayList<Foods> array = new ArrayList<>();
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                        int slgnl = jsonObject.getInt("number_resources");
                        String cachLam = jsonObject.getString("making_foods");
                        String moTa = jsonObject.getString("describe_foods");
                        String image = jsonObject.getString("image");
                        String time = jsonObject.getString("time");

                       // array.add(new Foods(id, ten, time, nguyenlieu, image, moTa, cachLam, slgnl, nguon, trangThai));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
               // adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
        return array;
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
      //  getData(urlDataFoods);
        initView();
    }

    private void initView() {
       // callAPI = new CallAPI(getContext(),adapter);
       // arrayList = callAPI.getData();
        Foods f1 = new Foods( "https://media.cooky.vn/recipe/g1/3315/s800x500/recipe3315-635754951948774481.jpg");
        Foods f2 = new Foods("https://media.cooky.vn/recipe/g1/3315/s800x500/recipe3315-635754951948774481.jpg");
        Foods f3 = new Foods("https://media.cooky.vn/recipe/g1/3315/s800x500/recipe3315-635754951948774481.jpg");
        arrayFoods.add(f1);
        arrayFoods.add(f2);
        arrayFoods.add(f3);
     //  arrayFoods = getData(urlDataFoods);
     //   arrayFoods = new ArrayList<>();
        adapter = new FoodAdapter(getContext());
        adapter.setFoods(arrayFoods);
         binding.lvFoodHF.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
         binding.lvFoodHF.setAdapter(adapter);
        adapter.setCallBack(this);
    }
    @Override
    public void onClick(int position) { ;
    }
}

