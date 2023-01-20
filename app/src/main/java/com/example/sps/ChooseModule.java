package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseModule extends AppCompatActivity {

    Button ba,bs,bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_module);
        getSupportActionBar().hide();

        ba = (Button) findViewById(R.id.openadmin);
        bs = (Button) findViewById(R.id.openstudent);
        bt = (Button) findViewById(R.id.opentpo);


        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseModule.this, LoginAdmin.class);
                startActivity(intent);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseModule.this, LoginStudent.class);
                startActivity(intent);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseModule.this, LoginTPO.class);
                startActivity(intent);
            }
        });
    }
}