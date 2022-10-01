package com.example.roomdatabase.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private int key;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name= "phone")
    private String phone;

    @ColumnInfo(name= "address")
    private String address;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
