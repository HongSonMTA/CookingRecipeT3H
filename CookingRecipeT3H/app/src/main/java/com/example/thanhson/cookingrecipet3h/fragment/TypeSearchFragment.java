package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.R;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentMenuSearchBinding;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentTypeSearchBinding;
import com.example.thanhson.cookingrecipet3h.model.Foods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TypeSearchFragment extends Fragment {
    public static TypeSearchFragment instance;
    private ArrayList<Foods> foods = new ArrayList<>();
    private String urlDataFoods = "https://congthucnauanst.000webhostapp.com/connect/getDataFoods.php";
    private FragmentTypeSearchBinding binding;

    public static TypeSearchFragment getInstance() {
        if (instance == null) {
            instance = new TypeSearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTypeSearchBinding.inflate(inflater, container, false);
        initListView();
        return binding.getRoot();
    }

    private void initListView() {
        // foods = getData();
        String[] nguyenLieu = cutData("Thịt bò ngon, Xương bò, Hành tây, Gừng tươi, Hành tím, Quế khô, Mía, Bánh phở, Hành lá, Ngò gai, Chanh, Gia vị, Các loại rau thơm, ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, nguyenLieu);
        String[] slg = cutData("500 gram, 2kg, 200 gram, 100 gram,6 củ, 5 gram, 2 lóng, 500 gram, 100 gram, 50 gram, 2 trái, Gia vị, 1 rổ, ");
        ArrayAdapter<String> arrayAdapterSlg = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, slg);
        binding.listNguyenLieu.setAdapter(arrayAdapter);
        binding.listSlg.setAdapter(arrayAdapterSlg);
    }


    public ArrayList<Foods> getData() {
        final ArrayList<Foods> arrayList = new ArrayList<>();
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
                // adapter.notifyDataSetChanged();
                // foodHorizontalAdapter.notifyDataSetChanged();
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

    private String[] cutData(String data) {
        return data.split(",");
    }
}
