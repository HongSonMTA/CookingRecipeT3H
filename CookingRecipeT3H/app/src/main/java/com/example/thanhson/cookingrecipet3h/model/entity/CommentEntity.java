package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

public class CommentEntity {
    @SerializedName("id")
    String id = null;
    @SerializedName("content")
    String content = null;
    @SerializedName("commented_at")
    String commentedAt = null;
    @SerializedName("user_id")
    String userId = null;
}
