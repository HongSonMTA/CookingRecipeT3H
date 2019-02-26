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
import com.example.thanhson.cookingrecipet3h.databinding.ListResourcesBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;

import java.util.ArrayList;

public class ResourcesAdapter extends RecyclerView.Adapter<ResourcesAdapter.ViewHolder>  {
    private String[] arrResources;
    private String[] arrNumberResources;
    private LayoutInflater inflater;
    private ListResourcesBinding binding;

    public void setArrResources(String[] arrResources,String[] arrNumberResources ) {
        this.arrResources = arrResources;
        this.arrNumberResources = arrNumberResources;
        notifyDataSetChanged();
    }

    public ResourcesAdapter(String[] arrResources,String[] arrNumberResources,Context context) {
        inflater = LayoutInflater.from(context);
        this.arrResources = arrResources;
        this.arrNumberResources = arrNumberResources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListResourcesBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.bindata(arrResources[i],arrNumberResources[i]);
    }

    @Override
    public int getItemCount() {
        return arrNumberResources.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListResourcesBinding binding;

        public ViewHolder(ListResourcesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindata(String resource, String numberResource){
            binding.txtResource.setText(resource);
            binding.txtNumberResource.setText(numberResource);
//            binding.txtTime.setText(foods.getTime());
//            binding.txtStatus.setText(foods.getStatusFoods());
        }
    }
}
