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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public FoodEntity getData() {
        return data;
    }

    public void setData(FoodEntity data) {
        this.data = data;
    }

    public ArrayList<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentEntity> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return status + "\n" + data.getName() + "\n" + comments.size();
    }
}
