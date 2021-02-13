package com.nathan630pm.nk_lab_test_2.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//App developed by: Nathan Kennedy, Student ID: 101333351

@Entity(tableName = "tblMember")
public class Member {

    @PrimaryKey(autoGenerate = true)
    public int MemberId;
    public String name;
    public String email;
    public String age;


}
