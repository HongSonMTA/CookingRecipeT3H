package com.example.thanhson.cookingrecipet3h.networking;

import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {
        @GET("getDataFoods.php")
        Call<FoodResponse> getFoods();
        @GET("getDetailFoods.php")// a xem cái này đúng chưa a
        Call<FoodsEntity> getDetailFoods(@Query("food_id") int foodId); // tương đương cái cũ nhưng trông đỡ hơn
}
