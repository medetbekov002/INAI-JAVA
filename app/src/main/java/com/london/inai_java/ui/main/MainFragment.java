package com.london.inai_java.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.btnEmployee.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.employeeFragment);
        });

        binding.btnPastry.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.pastryFragment);
        });

        binding.btnProductStock.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.productStockFragment);
        });

        binding.btnAboutUs.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.aboutUsFragment);
        });
    }
}
