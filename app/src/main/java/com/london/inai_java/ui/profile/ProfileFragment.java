package com.london.inai_java.ui.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.london.inai_java.R;
import com.london.inai_java.ui.profile.model.Cake;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    private CircleImageView ivProfile;
    private TextView tvCakeName;
    private TextView tvCakeDescription;
    private ImageView btnArrow;

    private List<Cake> cakesList = new ArrayList<>();
    private int currentCakeIndex = 0; // Index to keep track of the current cake displayed

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        ivProfile = view.findViewById(R.id.iv_profile);
        tvCakeName = view.findViewById(R.id.tv_napoleon); // Update ID to a more general name
        tvCakeDescription = view.findViewById(R.id.tv_description);
        btnArrow = view.findViewById(R.id.btn_arrow);

        // Populate cakesList
        cakesList.add(new Cake(
                "Торт наполеон",
                "Торт, по форме напоминающий двууголку...",
                R.drawable.napoleon
        ));
        cakesList.add(new Cake(
                "Торт Медовик",
                "Медовый торт, изготовленный из слоёного теста...",
                R.drawable.medovik
        ));
        // Add more cakes as needed

        // Display initial cake details
        displayCakeDetails(currentCakeIndex);

        // Handle click on arrow to cycle through cakes
        btnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCakeIndex = (currentCakeIndex + 1) % cakesList.size(); // Cycle through cakes
                displayCakeDetails(currentCakeIndex); // Update UI with new cake details
            }
        });
    }

    private void displayCakeDetails(int index) {
        Cake cake = cakesList.get(index);
        ivProfile.setImageResource(cake.getImageResource());
        tvCakeName.setText(cake.getName());
        tvCakeDescription.setText(cake.getDescription());
    }
}
