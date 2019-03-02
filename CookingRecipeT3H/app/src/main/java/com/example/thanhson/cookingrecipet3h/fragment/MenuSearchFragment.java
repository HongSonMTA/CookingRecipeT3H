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

import com.example.thanhson.cookingrecipet3h.databinding.FragmentMenuSearchBinding;
import com.example.thanhson.cookingrecipet3h.model.entity.ListDataSearchEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.MenuEntity;
import com.example.thanhson.cookingrecipet3h.model.entity.TypeOfEntity;
import com.example.thanhson.cookingrecipet3h.networking.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MenuSearchFragment extends Fragment implements Callback<ListDataSearchEntity> {
    public static MenuSearchFragment instance;
    private FragmentMenuSearchBinding binding;
    private ArrayList<MenuEntity> menuFoods = new ArrayList<>();
    private ArrayList<Button> listBtn = new ArrayList<>();


    public static MenuSearchFragment getInstance() {
        if (instance == null) {
            instance = new MenuSearchFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuSearchBinding.inflate(inflater, container, false);
        getListDataSearch();

        return binding.getRoot();
    }

    private void getListDataSearch() {
        ApiBuilder.builder().getListData().enqueue(this);
    }


    @Override
    public void onResponse(Call<ListDataSearchEntity> call, retrofit2.Response<ListDataSearchEntity> response) {
        menuFoods = response.body().getMenu();
        initListButton();
    }

    @Override
    public void onFailure(Call<ListDataSearchEntity> call, Throwable t) {
        Log.e("onFail", t.toString());
    }


    private void initListButton() {
        listBtn.add(binding.btnThucdon1);
        listBtn.add(binding.btnThucdon2);
        listBtn.add(binding.btnThucdon3);
        listBtn.add(binding.btnThucdon4);
        listBtn.add(binding.btnThucdon5);
        listBtn.add(binding.btnThucdon6);
        listBtn.add(binding.btnThucdon7);
        listBtn.add(binding.btnThucdon8);
        listBtn.add(binding.btnThucdon9);
        listBtn.add(binding.btnThucdon10);

        for (int i = 0; i < listBtn.size(); i++) {
            listBtn.get(i).setText(menuFoods.get(i).getName());
        }
    }
}
