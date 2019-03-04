package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

public class ImageEntity {
    @SerializedName("id")
    String id = null;
    @SerializedName("url_image")
    String url = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
