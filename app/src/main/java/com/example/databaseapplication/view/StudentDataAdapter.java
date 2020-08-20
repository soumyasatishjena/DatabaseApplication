package com.example.databaseapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaseapplication.R;
import com.example.databaseapplication.databinding.AdapterStudentDataBinding;
import com.example.databaseapplication.pojo.Student;

import java.util.List;

public class StudentDataAdapter extends RecyclerView.Adapter<StudentDataAdapter.StudentHolder> {

    private LayoutInflater layoutInflater;
    private List<Student> list;

    public StudentDataAdapter(Context context, List<Student> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterStudentDataBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.adapter_student_data, parent, false);
        return new StudentHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.binding.setStudentData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {
        AdapterStudentDataBinding binding;
        public StudentHolder(@NonNull AdapterStudentDataBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
