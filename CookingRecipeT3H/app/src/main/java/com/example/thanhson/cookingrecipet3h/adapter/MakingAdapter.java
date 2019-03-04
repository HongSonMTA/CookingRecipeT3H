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
import com.example.thanhson.cookingrecipet3h.databinding.ListMakingFoodBinding;
import com.example.thanhson.cookingrecipet3h.databinding.ListResourcesBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.model.entity.ImageEntity;

import java.util.ArrayList;

public class MakingAdapter extends RecyclerView.Adapter<MakingAdapter.ViewHolder>  {
    private String[] arrMaking;
    private ArrayList<ImageEntity> arrImage;
    private LayoutInflater inflater;
    private ListMakingFoodBinding binding;

    public void setArrResources(ArrayList<ImageEntity> arrImage,String[] arrMaking ) {
        this.arrImage = arrImage;
        this.arrMaking = arrMaking;
        notifyDataSetChanged();
    }

    public MakingAdapter(ArrayList<ImageEntity> arrImage,String[] arrMaking,Context context) {
        inflater = LayoutInflater.from(context);
        this.arrMaking = arrMaking;
        this.arrImage = arrImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListMakingFoodBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.bindata(arrImage.get(i),arrMaking[i]);
    }

    @Override
    public int getItemCount() {
        return arrImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListMakingFoodBinding binding;

        public ViewHolder(ListMakingFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindata(ImageEntity imageEntity, String making){
            binding.txtStep.setText("Bước " + imageEntity.getId()+":");
            binding.txtMaking.setText(making);
            Glide.with(itemView.getContext())
                    .load(imageEntity.getUrl())
                    .into(binding.imageStep);
        }
    }
}
