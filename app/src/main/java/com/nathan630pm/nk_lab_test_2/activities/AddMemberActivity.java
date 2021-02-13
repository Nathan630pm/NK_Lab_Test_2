package com.nathan630pm.nk_lab_test_2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nathan630pm.nk_lab_test_2.R;
import com.nathan630pm.nk_lab_test_2.database.model.Member;
import com.nathan630pm.nk_lab_test_2.repository.MemberRepository;

//App developed by: Nathan Kennedy, Student ID: 101333351

public class AddMemberActivity extends AppCompatActivity {

    private static final String TAG = "AddMemberActivity";
    private EditText ETName;
    private EditText ETEmail;
    private EditText ETAge;
    private Button BAddMember;

    private MemberRepository myRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        this.ETName = findViewById(R.id.ETName);
        this.ETEmail = findViewById(R.id.ETEmail);
        this.ETAge = findViewById(R.id.ETAge);

        this.BAddMember = findViewById(R.id.BAddMember);

        this.myRepo = new MemberRepository(getApplication());

        BAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMember();

            }
        });

    }

    private void addMember() {
        Log.d(TAG, "Add member clicked.");
        if(ETName.getText().toString().equals("") || ETEmail.getText().toString().equals("") || ETAge.getText().toString().equals("")){
            Log.e(TAG, "please enter a name and or email.");
        }
        else {
            Member addmember = new Member();
            addmember.name = ETName.getText().toString();
            addmember.email = ETEmail.getText().toString();
            addmember.age = ETAge.getText().toString();

            myRepo.insertMember(addmember);
            finish();

        }
    }


}