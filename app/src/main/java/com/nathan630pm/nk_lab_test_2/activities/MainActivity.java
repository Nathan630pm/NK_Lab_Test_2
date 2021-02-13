package com.nathan630pm.nk_lab_test_2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.nathan630pm.nk_lab_test_2.R;
import com.nathan630pm.nk_lab_test_2.adapter.MemberAdapter;
import com.nathan630pm.nk_lab_test_2.database.model.Member;
import com.nathan630pm.nk_lab_test_2.repository.MemberRepository;
import com.nathan630pm.nk_lab_test_2.viewmodel.MemberViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<Member> members;
    private RecyclerView recyclerView;
    private MemberAdapter adapter;
    private MemberRepository myRepo;
    private Button btnAddMember;
    private MemberViewModel memberViewModel;
    private List<Member> memberList = new ArrayList<>();
    private MemberRepository memberRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        members = new ArrayList<>();
        myRepo = new MemberRepository(getApplication());
        btnAddMember = findViewById(R.id.btnAddMember);

        memberViewModel = new MemberViewModel(getApplication());

        if(myRepo.getMembers().size() == 0) {

        }
        else {
            members.addAll(myRepo.getMembers());
            Log.d(TAG, "loaded the items");
            Log.e(TAG, "Members: " + myRepo.getMembers().toString());
        }

        Log.i(TAG, members.toString());

        adapter = new MemberAdapter(members, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddMemberActivity.class));
            }
        });



    }
}