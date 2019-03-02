package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListDataSearchEntity {
    @SerializedName("status")
    Boolean status = null;
    @SerializedName("kingOf")
    ArrayList<KingOffEntity> kingOf = null;
    @SerializedName("menu")
    ArrayList<MenuEntity> menu = null;
    @SerializedName("typeOf")
    ArrayList<TypeOfEntity> typeOf = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<KingOffEntity> getKingOf() {
        return kingOf;
    }

    public void setKingOf(ArrayList<KingOffEntity> kingOf) {
        this.kingOf = kingOf;
    }

    public ArrayList<MenuEntity> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuEntity> menu) {
        this.menu = menu;
    }

    public ArrayList<TypeOfEntity> getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(ArrayList<TypeOfEntity> typeOf) {
        this.typeOf = typeOf;
    }
}
