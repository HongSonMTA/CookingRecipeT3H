package com.example.thanhson.cookingrecipet3h.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    private static final String BASE_URL = "https://congthucnauanst.000webhostapp.com/connect/";
    public  static ApiRequest builder(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();//Url goc
        return  retrofit.create(ApiRequest.class);
    }
    public  static ApiRequest builderWithOutFormat(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.9:8080/chat-1.0-SNAPSHOT/api/foods/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();//Url goc
        return  retrofit.create(ApiRequest.class);
    }

}
