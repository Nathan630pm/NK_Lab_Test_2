package com.nathan630pm.nk_lab_test_2.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nathan630pm.nk_lab_test_2.database.MyDatabase;
import com.nathan630pm.nk_lab_test_2.database.dao.MemberDao;
import com.nathan630pm.nk_lab_test_2.database.model.Member;

import java.util.List;

//App developed by: Nathan Kennedy, Student ID: 101333351

public class MemberRepository {


    private LiveData<List<Member>> members;
    private MyDatabase db;
    private MemberDao memberDao;

    public MemberRepository(Application application) {
        db = MyDatabase.getDatabase(application);
        memberDao = db.memberDao();
        members = memberDao.getMembers();
    }

    public LiveData<List<Member>> getMembers() {return members;}

    public int getMembersSize() {return memberDao.getMemberSize();}

    public Member getMember(int id) {return memberDao.getMember(id);}

    public void insertMember(Member member) {memberDao.insert(member);}

    public void updateMember(Member member) {memberDao.update(member);}

    public void deleteMember(Member member) {memberDao.delete(member);}

}
