package com.nathan630pm.nk_lab_test_2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nathan630pm.nk_lab_test_2.R;

public class AddMemberActivity extends AppCompatActivity {

    private static final String TAG = "AddMemberActivity";
    private EditText ETName;
    private EditText ETEmail;
    private Button BAddMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        this.ETName = findViewById(R.id.ETName);
        this.ETEmail = findViewById(R.id.ETEmail);

        this.BAddMember = findViewById(R.id.BAddMember);

        BAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMember();
            }
        });

    }

    private void addMember() {
        Log.d(TAG, "Add member clicked.");
    }


}