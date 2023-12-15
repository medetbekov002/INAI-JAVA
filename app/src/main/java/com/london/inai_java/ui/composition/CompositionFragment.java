package com.london.inai_java.ui.composition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentCompositionBinding;
import com.london.inai_java.ui.composition.model.Composition;
import com.london.inai_java.ui.employee.model.Employee;

import java.util.ArrayList;

public class CompositionFragment extends Fragment {

    private FragmentCompositionBinding binding;
    private ArrayList<Composition> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCompositionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        binding.btnArrow.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigateUp();
        });
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new Composition("Торт Наполеон", R.drawable.napoleon));
        list.add(new Composition("Торт Медовик", R.drawable.medovik));
        list.add(new Composition("Торт Красный бархат", R.drawable.krasnyi_barhat));
        list.add(new Composition("Торт Сникерс", R.drawable.snikers));
        list.add(new Composition("Торт Зебра", R.drawable.zebra));
        list.add(new Composition("Торт Брауни", R.drawable.brayni));
        list.add(new Composition("Торт Три шоколада", R.drawable.three_chocolate));
        list.add(new Composition("Торт Прага", R.drawable.praga));
        list.add(new Composition("Торт Трюфельный", R.drawable.trufel));
        list.add(new Composition("Торт Вупи Пай", R.drawable.vupi_pay));
    }
}
