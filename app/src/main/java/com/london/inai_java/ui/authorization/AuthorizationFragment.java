package com.london.inai_java.ui.authorization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentAuthorizationBinding;

public class AuthorizationFragment extends Fragment {

    private FragmentAuthorizationBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.btnEnterViaGoogle.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.accountFragment);
        });
        binding.btnContinueWithApple.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.accountFragment);
        });
        binding.btnContinueWithVk.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.accountFragment);
        });
    }
}
