package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.R;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;

import java.util.ArrayList;

public class FlipperAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoodResponse.Foods> arrayList = new ArrayList<>();

    public FlipperAdapter(Context context, ArrayList<FoodResponse.Foods> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodResponse.Foods foods = arrayList.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.flipper_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(context).load(foods.getImage()).into(imageView);
        return view;
    }
}
