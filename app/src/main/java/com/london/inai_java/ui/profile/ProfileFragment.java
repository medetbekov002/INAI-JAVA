package com.london.inai_java.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentProfileBinding;
import com.london.inai_java.local.EmployeeEntity;
import com.london.inai_java.local.MyApp;
import com.london.inai_java.local.dao.EmployeeDao;
import com.london.inai_java.local.database.EmployeeDatabase;

import java.util.List;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Получите экземпляр базы данных
        EmployeeDatabase db = ((MyApp) requireActivity().getApplication()).getEmployeeDatabase();
        EmployeeDao employeeDao = db.employeeDao();

// Создание нового сотрудника
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setName("Имя сотрудника");
        newEmployee.setImage(R.drawable.ic_profile1); // Установите изображение, если необходимо
        employeeDao.insertEmployee(newEmployee);

// Получение всех сотрудников
        List<EmployeeEntity> employees = employeeDao.getAllEmployees();

// Обновление сотрудника
        EmployeeEntity employeeToUpdate = employees.get(0);
        employeeToUpdate.setName("Новое имя сотрудника");
        employeeDao.updateEmployee(employeeToUpdate);

// Удаление сотрудника
        EmployeeEntity employeeToDelete = employees.get(1);
        employeeDao.deleteEmployee(employeeToDelete);


        binding.btnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigateUp();
            }
        });

        // Find TextView using View Binding
        TextView tvNumber = binding.tvNumber;

        // Set click listener using View Binding
        tvNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get phone number from TextView
                String phoneNumber = tvNumber.getText().toString();

                // Create intent to dial the phone number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

                // Check if there's an app to handle this intent
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    // Start the intent to make the call
                    startActivity(intent);
                }
            }
        });
    }
}
