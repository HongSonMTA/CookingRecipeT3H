package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentMakingSearchBinding;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentTypeSearchBinding;
import com.example.thanhson.cookingrecipet3h.model.entity.ListDataSearchEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.TypeOfEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MakingSearchFragment extends Fragment implements Callback<ListDataSearchEntity> {
    public static MakingSearchFragment instance;
    private ArrayList<TypeOfEntity> typeOfFood = new ArrayList<>();
    private FragmentMakingSearchBinding binding;
    private ArrayList<Button> listBtn = new ArrayList<>();
    public static MakingSearchFragment getInstance() {
        if (instance == null) {
            instance = new MakingSearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMakingSearchBinding.inflate(inflater, container, false);
        getListDataSearch();

        return binding.getRoot();
    }


    private void getListDataSearch() {
        ApiBuilder.builder().getListData().enqueue(this);
    }


    @Override
    public void onResponse(Call<ListDataSearchEntity> call, retrofit2.Response<ListDataSearchEntity> response) {
        typeOfFood = response.body().getTypeOf();
        initListButton();

    }

    @Override
    public void onFailure(Call<ListDataSearchEntity> call, Throwable t) {
        Log.e("onFail", t.toString());
    }
    private void initListButton() {
        listBtn.add(binding.btnCachnau1);
        listBtn.add(binding.btnCachnau2);
        listBtn.add(binding.btnCachnau3);
        listBtn.add(binding.btnCachnau4);
        listBtn.add(binding.btnCachnau5);
        listBtn.add(binding.btnCachnau6);
        listBtn.add(binding.btnCachnau7);
        listBtn.add(binding.btnCachnau8);

        for (int i = 0; i < listBtn.size(); i++) {
            listBtn.get(i).setText(typeOfFood.get(i).getName());
        }
    }
}
