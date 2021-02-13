package com.nathan630pm.nk_lab_test_2.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblMember")
public class Member {

    @PrimaryKey
    public int MemberId;
    public String name;
    public String email;


}
