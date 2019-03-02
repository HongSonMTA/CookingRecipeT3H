package com.example.thanhson.cookingrecipet3h.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListDataSearchEntity {
    @SerializedName("status")
    private Boolean status ;
    @SerializedName("kindOf")
    private ArrayList<KindOffEntity> kindOf ;
    @SerializedName("menu")
    private ArrayList<MenuEntity> menu ;
    @SerializedName("typeOf")
    private ArrayList<TypeOfEntity> typeOf ;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<KindOffEntity> getKindOf() {
        return kindOf;
    }

    public void setKindOf(ArrayList<KindOffEntity> kindOf) {
        this.kindOf = kindOf;
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
