package com.london.inai_java.ui.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentOnBoardingBinding;
import com.london.inai_java.ui.onboarding.adapter.OnBoardingAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class OnBoardingFragment extends Fragment {

    private FragmentOnBoardingBinding binding;
    private OnBoardingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
        setIndicator();
    }

    private void setAdapter() {
        adapter = new OnBoardingAdapter(this::onStartClick);
        binding.viewPager.setAdapter(adapter);
    }

    private void setIndicator() {
        CircleIndicator3 indicator = binding.indicator;
        indicator.setViewPager(binding.viewPager);
    }

    private void onStartClick() {
        NavHostFragment.findNavController(this).navigate(R.id.mainFragment);
    }
}
