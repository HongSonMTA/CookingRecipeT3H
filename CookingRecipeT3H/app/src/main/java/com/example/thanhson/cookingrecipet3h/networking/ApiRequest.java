package com.example.thanhson.cookingrecipet3h.networking;

import com.example.thanhson.cookingrecipet3h.model.FoodResponse;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRequest {
        @GET("getDataFoods.php") //dduowngf link tro den API
        Call<FoodResponse> getFoods();
}
