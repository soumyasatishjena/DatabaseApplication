package com.example.databaseapplication.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.databaseapplication.pojo.Student;


@androidx.room.Database(entities = Student.class, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao StudentDao();

    private static volatile StudentDatabase studentDatabase;

    public static StudentDatabase getDatabase(final Context context) {
        if (studentDatabase == null) {
            synchronized (StudentDatabase.class) {
                if (studentDatabase == null) {
                    studentDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return studentDatabase;
    }
}
