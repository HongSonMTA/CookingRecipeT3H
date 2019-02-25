package com.example.thanhson.cookingrecipet3h.model;

import com.google.gson.annotations.SerializedName;

public class Foods { // bh e muốn lấy cái chi tiết foods đấy a
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

        public Foods(int id, String name, String time, String resources, String image, String describe_foods, String making_foods, String number_resources, String origin_foods,String status_foods) {
            this.id = id;
            this.name = name;
            this.time = time;
            this.resources = resources;
            this.image = image;
            this.describeFoods = describe_foods;
            this.makingFoods = making_foods;
            this.numberResources = number_resources;
            this.originFoods = origin_foods;
            this.statusFoods = status_foods;
        }

        public String getStatusFoods() {
            return statusFoods;
        }

        public void setStatusFoods(String trangThai) {
            this.statusFoods = trangThai;
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

        public String getResources() {
            return resources;
        }

        public void setResources(String nguyenLieu) {
            this.resources = nguyenLieu;
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

}
