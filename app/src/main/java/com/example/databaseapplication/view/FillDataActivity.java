package com.example.databaseapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.databaseapplication.R;
import com.example.databaseapplication.databinding.ActivityFillDataBinding;
import com.example.databaseapplication.pojo.Student;
import com.example.databaseapplication.viewmodel.StudentViewModel;

import java.util.UUID;

public class FillDataActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityFillDataBinding binding;
    private String gender="";
    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_data);
        viewModel = new StudentViewModel(this);
        clickData();
    }

    private void clickData() {
        binding.male.setOnClickListener(this);
        binding.female.setOnClickListener(this);
        binding.submit.setOnClickListener(this);
    }

    private void getData() {
        String name = binding.name.getText().toString().trim();
        String address = binding.address.getText().toString().trim();
        String age = binding.age.getText().toString().trim();
        String date = binding.date.getText().toString().trim();
        if(!name.isEmpty()){
            if(!address.isEmpty()){
                if(!gender.isEmpty()){
                    if(!age.isEmpty()){
                        age= age + " Years";
                        if(!date.isEmpty()){
                          String id = UUID.randomUUID().toString();
                            viewModel.insertData(new Student(id, name, address, gender,  age, date));
                        }else
                            binding.date.setError("Set A Date");
                    }else
                        binding.age.setError("Set age of Student");
                }else
                    binding.gender.setError("Select a gender type");
            }else
                binding.address.setError("Address Field Cannot be Empty");
        }else
            binding.name.setError("Name Field Cannot be Empty");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.male:
                gender = "Male";
                binding.male.setChecked(true);
                binding.female.setChecked(false);
                break;
            case R.id.female:
                gender = "Female";
                binding.female.setChecked(true);
                binding.male.setChecked(false);
                break;
            case R.id.submit:
                getData();
                onBackPressed();
                break;
        }
    }
}