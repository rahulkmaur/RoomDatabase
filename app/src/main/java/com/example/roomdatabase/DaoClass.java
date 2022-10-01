package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.EntityClass.UserModel;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    @Query("Select *from user")
    List<UserModel>getAllData();
}
