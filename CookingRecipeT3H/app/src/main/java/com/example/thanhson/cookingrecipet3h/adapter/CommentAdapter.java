package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.databinding.ListCommentBinding;
import com.example.thanhson.cookingrecipet3h.databinding.ListFoodsBinding;
import com.example.thanhson.cookingrecipet3h.databinding.ListResourcesBinding;
import com.example.thanhson.cookingrecipet3h.model.FoodResponse;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.model.entity.CommentEntity;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>  {
    private LayoutInflater inflater;
    private ListCommentBinding binding;
    private ArrayList<CommentEntity> arrCommnent;

    public void setArrResources(ArrayList<CommentEntity> arrCommnent) {
        this.arrCommnent = arrCommnent;
        notifyDataSetChanged();
    }

    public CommentAdapter(ArrayList<CommentEntity> arrCommnent,Context context) {
        inflater = LayoutInflater.from(context);
        this.arrCommnent = arrCommnent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ListCommentBinding.inflate(inflater,viewGroup,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.bindata(arrCommnent.get(i));
    }

    @Override
    public int getItemCount() {
        return arrCommnent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListCommentBinding binding;

        public ViewHolder(ListCommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindata(CommentEntity arrCommnent){
            binding.txtContent.setText(arrCommnent.getContent());
            binding.txtTime.setText(arrCommnent.getCommentedAt());
        }
    }
}
