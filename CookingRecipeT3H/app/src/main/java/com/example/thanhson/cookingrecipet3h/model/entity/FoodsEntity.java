package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FoodsEntity {
    @SerializedName("status")
    Boolean status = null;
    @SerializedName("data")
    FoodEntity data = null;
    @SerializedName("comments")
    ArrayList<CommentEntity> comments = null;

    @Override
    public String toString() {
        return status + "\n" + data.getName() + "\n" + comments.size();
    }
}
