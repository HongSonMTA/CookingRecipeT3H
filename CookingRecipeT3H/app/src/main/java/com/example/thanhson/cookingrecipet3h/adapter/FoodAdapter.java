package com.example.thanhson.cookingrecipet3h.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.thanhson.cookingrecipet3h.model.Foods;
import com.example.thanhson.cookingrecipet3h.databinding.ListFoodsBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private ArrayList<Foods> arrFoods ;
    private LayoutInflater inflater;
    private ListFoodsBinding binding;
    private ItemClickCallBack callBack ;

    public void setCallBack(ItemClickCallBack callBack) {
        this.callBack = callBack;
    }
    public void setFoods(ArrayList<Foods> foods) {
        this.arrFoods = foods;
        notifyDataSetChanged();
    }

    public FoodAdapter(Context context) {
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
        viewHolder.binData(arrFoods.get(i));
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
        public void binData(Foods foods) {
//            binding.txtName.setText(foods.getName());
////            binding.txtNguyenLieu.setText("Ng.Liệu : "+foods.getNguyenLieu());
////            binding.txtTime.setText(" "+ foods.getTime() + " Phút");
////            binding.txtTT.setText(" "+foods.getTrangThai());
            Glide.with(itemView.getContext())
                        .load(foods.getImage())
                        .into(binding.imageAv);
        }
    }
    public interface ItemClickCallBack{
        void onClick(int position);
    }
}
