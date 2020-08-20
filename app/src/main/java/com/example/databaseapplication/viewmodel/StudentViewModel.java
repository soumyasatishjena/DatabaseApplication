package com.example.databaseapplication.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.databaseapplication.model.StudentModel;
import com.example.databaseapplication.pojo.Student;

import java.util.List;

public class StudentViewModel extends ViewModel {

    private StudentModel studentModel;

    public StudentViewModel(Context context) {
      studentModel = new StudentModel(context);
    }

    public LiveData<List<Student>> getListData() {
        return studentModel.getList();
    }

    public void insertData(Student student){
        studentModel.insert(student);
    }

    @Override
    protected void onCleared() {
        studentModel = null;
        super.onCleared();
    }

}
