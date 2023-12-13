package com.london.inai_java.ui.onboarding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.london.inai_java.R;
import com.london.inai_java.databinding.ItemOnboardBinding;
import com.london.inai_java.ui.onboarding.model.OnBoarding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder> {

    private final List<OnBoarding> data = new ArrayList<>();
    private final Runnable onStartClick;

    public OnBoardingAdapter(Runnable onStartClick) {
        this.onStartClick = onStartClick;

        // Initialize your data here
        data.add(new OnBoarding(R.drawable.welcome, "Дорогие гурманы и\nсладкоежки!"));
        data.add(new OnBoarding(
                R.drawable.pastry_cook,
                "Добро пожаловать в\nнаш уютный\nкондитерский дом, где\nкаждый десерт - \nнастоящее\nпроизведение\nискусства,созданное с\nлюбовью и тщательным\nвниманием к деталям."
        ));
        data.add(new OnBoarding(
                R.drawable.baking,
                "Здесь, в мире\nволшебных вкусов и\nизысканных угощений,\nмы рады приветствовать\nвас как гостей своей\nсладкой семьи."
        ));
        data.add(new OnBoarding(
                R.drawable.pastry_bag,
                "Будьте готовы к\nпутешевствию по миру\nсладких наслаждений!"
        ));
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOnboardBinding binding = ItemOnboardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OnBoardingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class OnBoardingViewHolder extends RecyclerView.ViewHolder {

        private final ItemOnboardBinding binding;

        public OnBoardingViewHolder(ItemOnboardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(OnBoarding onBoarding) {
            binding.ivImage.setImageResource(onBoarding.getImage().orElse(0));
            binding.tvTitle.setText(onBoarding.getTitle());

            binding.btnStart.setVisibility(getAdapterPosition() == data.size() - 1 ? View.VISIBLE : View.GONE);
            binding.btnStart.setOnClickListener(v -> onStartClick.run());
        }
    }
}
