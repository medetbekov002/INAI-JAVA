package com.london.inai_java.ui.about;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.databinding.FragmentAboutUsBinding;

public class AboutUsFragment extends Fragment {

    private FragmentAboutUsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAboutUsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnArrow.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigateUp();
        });

        // Instagram intent
        binding.btnInstagram.setOnClickListener(v -> {
            String instagramUrl = "https://www.instagram.com/wiestx1";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(instagramUrl));

            PackageManager packageManager = requireActivity().getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(requireContext(), "Instagram app is not installed", Toast.LENGTH_SHORT).show();
            }
        });

        // Telegram intent
        binding.btnTelegram.setOnClickListener(v -> {
            Intent telegramIntent = new Intent(Intent.ACTION_VIEW);
            telegramIntent.setData(Uri.parse("https://t.me/mktmwiest"));

            startActivity(telegramIntent);
        });

        // WhatsApp intent
        binding.btnWhatsapp.setOnClickListener(v -> {
            String phoneNumber = "0708540691";

            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse("https://wa.me/+996708540691"));

            startActivity(whatsappIntent);
        });
    }
}
