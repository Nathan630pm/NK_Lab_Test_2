package com.nathan630pm.nk_lab_test_2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nathan630pm.nk_lab_test_2.database.model.Member;
import com.nathan630pm.nk_lab_test_2.repository.MemberRepository;

import java.util.List;

//App developed by: Nathan Kennedy, Student ID: 101333351

public class MemberViewModel extends AndroidViewModel {

    private LiveData<List<Member>> allMembers;
    private MemberRepository memberRepository;

    public MemberViewModel(@NonNull Application application) {
        super(application);
        memberRepository = new MemberRepository(application);
//        allMembers = memberRepository.getMembers();
    }

    public LiveData<List<Member>> getAllMembers() {return memberRepository.getMembers();}

    public int getMemberSize() {return memberRepository.getMembersSize();}

    public Member getMember(int id) {return memberRepository.getMember(id);}

    public void insertMember(Member member) {memberRepository.insertMember(member);}

    public void updateMember(Member member) {memberRepository.updateMember(member);}

    public void deleteMember(Member member) {memberRepository.deleteMember(member);}
}
