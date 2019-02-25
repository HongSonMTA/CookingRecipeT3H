package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

public class FoodEntity {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("time")
    private String time;
    @SerializedName("resources")
    private String resources;
    @SerializedName("image")
    private String image;
    @SerializedName("describe_foods")
    private String describeFoods;
    @SerializedName("making_foods")
    private String makingFoods;
    @SerializedName("number_resources")
    private String numberResources;
    @SerializedName("origin_foods")
    private String originFoods;
    @SerializedName("status")
    private String statusFoods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribeFoods() {
        return describeFoods;
    }

    public void setDescribeFoods(String describeFoods) {
        this.describeFoods = describeFoods;
    }

    public String getMakingFoods() {
        return makingFoods;
    }

    public void setMakingFoods(String makingFoods) {
        this.makingFoods = makingFoods;
    }

    public String getNumberResources() {
        return numberResources;
    }

    public void setNumberResources(String numberResources) {
        this.numberResources = numberResources;
    }

    public String getOriginFoods() {
        return originFoods;
    }

    public void setOriginFoods(String originFoods) {
        this.originFoods = originFoods;
    }

    public String getStatusFoods() {
        return statusFoods;
    }

    public void setStatusFoods(String statusFoods) {
        this.statusFoods = statusFoods;
    }
}
