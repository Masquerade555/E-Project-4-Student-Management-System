package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentModule extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_module);
        getSupportActionBar().hide();

        bt1 = (Button) findViewById(R.id.smcompany);
        bt2 = (Button) findViewById(R.id.smnotification);
        bt3 = (Button) findViewById(R.id.smprevious);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentModule.this, CompanyDetails.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentModule.this, RecNotification.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentModule.this, ViewPreviousPaper.class);
                startActivity(intent);
            }
        });
    }
}