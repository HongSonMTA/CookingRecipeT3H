package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.databinding.ListFoodsBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder>  {
    private ArrayList<FoodResponse.Foods> arrFoods = new ArrayList<>();
    private LayoutInflater inflater;
    private ListFoodsBinding binding;

    public void setArrFoods(ArrayList<FoodResponse.Foods> arrFoods) {
        this.arrFoods = arrFoods;
        notifyDataSetChanged();
    }

    public FoodsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListFoodsBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindata(arrFoods.get(i));
    }

    @Override
    public int getItemCount() {
        return arrFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListFoodsBinding binding;

        public ViewHolder(ListFoodsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindata(FoodResponse.Foods foods){
            binding.txtNguyenlieu.setText(foods.getNguyenLieu());
            binding.txtName.setText(foods.getName());
            binding.txtTime.setText(foods.getTime());
            binding.txtStatus.setText(foods.getTrangThai());
            Glide.with(itemView.getContext())
                    .load(foods.getImage())
                    .into(binding.imageAv);
        }
    }
}
