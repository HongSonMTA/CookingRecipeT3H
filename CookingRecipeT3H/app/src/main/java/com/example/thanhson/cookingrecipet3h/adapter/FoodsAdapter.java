package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.databinding.ListFoodsBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder>  {
    private ArrayList<FoodResponse.Foods> arrFoods;
    private LayoutInflater inflater;
    private ListFoodsBinding binding;
    private ItemClickCallBack callBack;

    public void setCallBack(ItemClickCallBack callBack) {
        this.callBack = callBack;
    }

    public void setArrFoods(ArrayList<FoodResponse.Foods> arrFoods) {
        this.arrFoods.clear();
        this.arrFoods.addAll(arrFoods);
        notifyDataSetChanged();
    }

    public FoodsAdapter(ArrayList<FoodResponse.Foods> arrFoods,Context context) {
        inflater = LayoutInflater.from(context);
        this.arrFoods = arrFoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListFoodsBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.bindata(arrFoods.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!= null){
                    callBack.onClick(i);
                }
            }
        });
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
            binding.txtNguyenlieu.setText(foods.getResources());
            binding.txtName.setText(foods.getName());
            binding.txtTime.setText(foods.getTime());
            binding.txtStatus.setText(foods.getStatusFoods());
            Glide.with(itemView.getContext())
                    .load(foods.getImage())
                    .into(binding.imageAv);
        }
    }
    public interface ItemClickCallBack{
        void onClick(int position);
    }
}
