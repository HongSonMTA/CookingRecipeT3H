package com.example.thanhson.cookingrecipet3h.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public  class FoodResponse {
    @SerializedName("data")
    private ArrayList<Foods> arrFoods;

    public ArrayList<Foods> getArrFoods() {
        return arrFoods;
    }

public class Foods {

    private int id;
    private String name;
    private String time;
    private String nguyenLieu;
    private String image;
    private String moTa;
    private String cachLam;
    private String soLuongNL;
    private String xuatSu;
    private String trangThai;

    public Foods(int id, String name, String time, String nguyenLieu, String image, String moTa, String cachLam, String soLuongNL, String xuatSu,String trangThai) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.nguyenLieu = nguyenLieu;
        this.image = image;
        this.moTa = moTa;
        this.cachLam = cachLam;
        this.soLuongNL = soLuongNL;
        this.xuatSu = xuatSu;
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

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

    public String getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(String nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getCachLam() {
        return cachLam;
    }

    public void setCachLam(String cachLam) {
        this.cachLam = cachLam;
    }

    public String getSoLuongNL() {
        return soLuongNL;
    }

    public void setSoLuongNL(String soLuongNL) {
        this.soLuongNL = soLuongNL;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(String xuatSu) {
        this.xuatSu = xuatSu;
    }
}

}
