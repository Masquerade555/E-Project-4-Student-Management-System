package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TPOModule extends AppCompatActivity {

    Button bt1, bt2, bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpomodule);
        getSupportActionBar().hide();

        bt1 = (Button) findViewById(R.id.addcompany);
        bt2 = (Button) findViewById(R.id.addnotif);
        bt3 = (Button) findViewById(R.id.addprevious);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOModule.this, AddCompany.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOModule.this, SendNotification.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOModule.this, AddPreviousPaper.class);
                startActivity(intent);
            }
        });


    }
}