package com.example.thanhson.cookingrecipet3h.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.thanhson.cookingrecipet3h.databinding.FragmentSearchBinding;

    public class SearchFragment extends Fragment {
        private static SearchFragment instance;
        private FragmentSearchBinding binding;
        public static SearchFragment getInstance() {
            if (instance == null) {
                instance = new SearchFragment();
            }
            return instance;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentSearchBinding.inflate(inflater,container,false);
            binding.txtSearch.setText("Search");
            return binding.getRoot();
        }
}
