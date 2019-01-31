package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanhson.cookingrecipet3h.databinding.FragmentAccountBinding;


public class AccountFragment extends Fragment {
    private static AccountFragment  instance;
    private FragmentAccountBinding binding;
    public static AccountFragment getInstance() {
        if (instance == null) {
            instance = new AccountFragment();
        }
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater,container,false);
        binding.txtAccount.setText("Account");
        return binding.getRoot();
    }
}
