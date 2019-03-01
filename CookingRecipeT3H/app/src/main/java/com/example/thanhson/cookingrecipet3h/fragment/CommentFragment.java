package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.adapter.CommentAdapter;
import com.example.thanhson.cookingrecipet3h.adapter.ResourcesAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentCommentBinding;
import com.example.thanhson.cookingrecipet3h.model.entity.CommentEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.FoodsEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CommentFragment extends Fragment {
    private static CommentFragment  instance;
    private FragmentCommentBinding binding;
    private CommentAdapter adapter;
    private int id;
    private ArrayList<CommentEntity> arrayList;

    public static CommentFragment getInstance() {
        if (instance == null) {
            instance = new CommentFragment();
        }
        return instance;
    }
    public void setId(int id) {
        this.id = id;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCommentBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }
    private void initView() {
        getData();
        arrayList = new ArrayList<>();
        adapter = new CommentAdapter(arrayList,getActivity());
        binding.lvComment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.lvComment.setAdapter(adapter);
    }
    private void getData() {
        ApiBuilder.builder().getDetailFoods(id).enqueue(new Callback<FoodsEntity>() {
            @Override
            public void onResponse(Call<FoodsEntity> call, Response<FoodsEntity> response) {
                FoodsEntity foodsEntity  = response.body();
                arrayList = foodsEntity.getComments();
                adapter.setArrResources(arrayList);
            }

            @Override
            public void onFailure(Call<FoodsEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
