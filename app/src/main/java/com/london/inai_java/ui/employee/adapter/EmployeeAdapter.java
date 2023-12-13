package com.london.inai_java.ui.employee.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.london.inai_java.ui.employee.model.Employee;
import com.london.inai_java.databinding.ItemEmployeeBinding;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private final ArrayList<Employee> list;
    private final Runnable onClick;

    public EmployeeAdapter(ArrayList<Employee> list, Runnable onClick) {
        this.list = list;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemEmployeeBinding binding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private final ItemEmployeeBinding binding;

        public EmployeeViewHolder(ItemEmployeeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Employee employee) {
            employee.getImage().ifPresent(binding.ivAvatar::setImageResource);
            binding.tvName.setText(employee.getName());
            itemView.setOnClickListener(v -> onClick.run());
        }
    }
}
