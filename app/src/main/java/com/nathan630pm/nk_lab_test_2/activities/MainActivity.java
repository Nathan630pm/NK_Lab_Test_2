package com.nathan630pm.nk_lab_test_2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
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

//App developed by: Nathan Kennedy, Student ID: 101333351

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
    private ItemTouchHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        members = new ArrayList<>();
        myRepo = new MemberRepository(getApplication());
        btnAddMember = findViewById(R.id.btnAddMember);

        memberViewModel = new MemberViewModel(getApplication());

        helper = new ItemTouchHelper(simpleCallback);
        helper.attachToRecyclerView(recyclerView);



//        members.addAll(myRepo.getMembers());
        Log.d(TAG, "loaded the items");
        Log.e(TAG, "Members: " + members.toString());
        Log.e(TAG, "Members Size: " + members.size());

        memberViewModel.getAllMembers().observe(this, members1 -> {
            members.removeAll(members);
            members.addAll(memberViewModel.getAllMembers().getValue());
            adapter.notifyDataSetChanged();
        });


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

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            memberViewModel.deleteMember(members.get(viewHolder.getAdapterPosition()));
            memberViewModel.getAllMembers();
        }
    };
}