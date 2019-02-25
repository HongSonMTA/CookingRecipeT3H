package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.databinding.ListFoodHorizontalBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;

import java.util.ArrayList;

public class FoodHorizontalAdapter extends RecyclerView.Adapter<FoodHorizontalAdapter.ViewHolder> {
    private ArrayList<FoodResponse.Foods> arrFoods = new ArrayList<>();
    private LayoutInflater inflater;
    private ListFoodHorizontalBinding binding;
    private ItemClickCallBack callBack ;

    public void setCallBack(ItemClickCallBack callBack) {
        this.callBack = callBack;
    }
    public void setArrFoods(ArrayList<FoodResponse.Foods> arrFoods) {
        this.arrFoods = arrFoods;
        notifyDataSetChanged();
    }

    public FoodHorizontalAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListFoodHorizontalBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binData(arrFoods.get(i));
    }

    @Override
    public int getItemCount() {
        return arrFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListFoodHorizontalBinding binding;

        public ViewHolder(ListFoodHorizontalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void binData(FoodResponse.Foods foods) {
            Glide.with(itemView.getContext())
                    .load(foods.getImage())
                    .into(binding.imageAv);
        }
    }
    public interface ItemClickCallBack{
        void onClick(int position);
    }
}
