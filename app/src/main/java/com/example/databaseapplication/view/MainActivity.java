package com.example.databaseapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.databaseapplication.R;
import com.example.databaseapplication.databinding.ActivityMainBinding;
import com.example.databaseapplication.pojo.Student;
import com.example.databaseapplication.viewmodel.StudentViewModel;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new StudentViewModel(this);
        binding.textAddNew.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.textAddNew){
            startActivity(new Intent(this, FillDataActivity.class));
        }
    }

    @Override
    protected void onResume() {
        getDataFromDatabase();
        super.onResume();
    }

    private void getDataFromDatabase() {
        viewModel.getListData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
             if(students.size()>0){
                 binding.recyclerView.setVisibility(VISIBLE);
                 binding.textNoData.setVisibility(GONE);
                 recyclerData(students);
             }else {
                 binding.recyclerView.setVisibility(GONE);
                 binding.textNoData.setVisibility(VISIBLE);
             }
            }
        });
    }

    private void recyclerData(List<Student> list){
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(new StudentDataAdapter(this, list));
    }
}