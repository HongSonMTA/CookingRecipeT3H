package com.example.thanhson.cookingrecipet3h.networking;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    private static final String BASE_URL = "https://congthucnauanst.000webhostapp.com/connect/";
    public  static ApiRequest builder(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(60,TimeUnit.SECONDS);
        client.writeTimeout(60,TimeUnit.SECONDS);
        client.connectTimeout(60,TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
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
