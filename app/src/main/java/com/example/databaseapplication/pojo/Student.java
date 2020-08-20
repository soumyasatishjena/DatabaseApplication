package com.example.databaseapplication.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    public Student(@NonNull String id, @NonNull String name, @NonNull String address,
                   @NonNull String gender, @NonNull String age, @NonNull String dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
    }

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private String id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "address")
    private String address;
    @NonNull
    @ColumnInfo(name = "gender")
    private String gender;
    @NonNull
    @ColumnInfo(name = "age")
    private String age;
    @NonNull
    @ColumnInfo(name = "dob")
    private String dob;


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getAge() {
        return age;
    }

    public void setAge(@NonNull String age) {
        this.age = age;
    }

    @NonNull
    public String getDob() {
        return dob;
    }
    public void setDob(@NonNull String dob) {
        this.dob = dob;
    }
}
