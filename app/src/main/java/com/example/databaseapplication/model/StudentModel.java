package com.example.databaseapplication.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.databaseapplication.database.StudentDao;
import com.example.databaseapplication.database.StudentDatabase;
import com.example.databaseapplication.pojo.Student;

import java.util.List;

public class StudentModel {

    private StudentDao studentDao;

    public StudentModel(Context context){
        StudentDatabase studentDatabase = StudentDatabase.getDatabase(context);
        this.studentDao = studentDatabase.StudentDao();
    }

    public void insert(Student student) {
        new InsertAsyncTask(studentDao).execute(student);
    }

    public LiveData<List<Student>> getList() {
        return studentDao.getAllStudent();
    }

    private static class OperationsAsyncTask extends AsyncTask<Student, Void, Void> {

       StudentDao mAsyncTaskDao;

        OperationsAsyncTask(StudentDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            return null;
        }
    }



    private static class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(StudentDao studentDao) {
            super(studentDao);
        }

        @Override
        protected Void doInBackground(Student... students) {
            mAsyncTaskDao.insert(students[0]);
            return null;
        }
    }
}
