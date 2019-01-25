package com.example.thanhson.cookingrecipet3h.networking;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.adapter.FoodAdapter;
import com.example.thanhson.cookingrecipet3h.model.Foods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CallAPI {
    private ArrayList<Foods> arrayFoods = new ArrayList<>();
    private FoodAdapter adapter;
    private Context context;
    private String urlDataFoods = "https://congthucnauanst.000webhostapp.com/connect/getDataFoods.php";

    public CallAPI(Context context,FoodAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
    }

    public ArrayList<Foods> getArrayFoods() {
        return arrayFoods;
    }

    public void setArrayFoods(ArrayList<Foods> arrayFoods) {
        this.arrayFoods = arrayFoods;
    }
    public ArrayList<Foods> getData() {
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
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

                       // arrayFoods.add(new Foods(id, ten, time, nguyenlieu, image, moTa, cachLam, slgnl, nguon, trangThai));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
        return arrayFoods;
    }
}
