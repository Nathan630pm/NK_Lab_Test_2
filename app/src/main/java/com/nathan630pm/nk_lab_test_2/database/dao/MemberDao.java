package com.nathan630pm.nk_lab_test_2.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nathan630pm.nk_lab_test_2.database.model.Member;

import java.util.List;

//App developed by: Nathan Kennedy, Student ID: 101333351

@Dao
public interface MemberDao extends BaseDao<Member> {

    @Query("SELECT * FROM tblMember ORDER BY MemberId asc")
    LiveData<List<Member>> getMembers();

    @Query("SELECT COUNT(*) FROM tblMember")
    int getMemberSize();

    @Query("SELECT * FROM tblMember WHERE MemberId = :id")
    Member getMember(int id);

    @Insert
    @Override
    void insert(Member cart);

    @Delete
    @Override
    void delete(Member cart);

    @Update
    @Override
    void update(Member cart);

}
