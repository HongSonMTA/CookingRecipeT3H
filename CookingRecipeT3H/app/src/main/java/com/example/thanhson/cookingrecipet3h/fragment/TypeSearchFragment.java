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
       // initListView();
        return binding.getRoot();
    }
}
