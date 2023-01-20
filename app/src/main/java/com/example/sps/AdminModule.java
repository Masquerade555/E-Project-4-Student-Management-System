package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AdminModule extends AppCompatActivity {

    Button bs,bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_module);
        getSupportActionBar().hide();

        bs = (Button) findViewById(R.id.addstudent);
        bt = (Button) findViewById(R.id.addtpo);


        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminModule.this, AddStudent.class);
                startActivity(intent);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminModule.this, AddTPO.class);
                startActivity(intent);
            }
        });

    }
}