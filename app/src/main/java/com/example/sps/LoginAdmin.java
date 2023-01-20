package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.StringReader;

public class LoginAdmin extends AppCompatActivity {

    Button btnlogin;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        getSupportActionBar().hide();

        btnlogin = (Button) findViewById(R.id.loginadminsub);
        name = (EditText) findViewById(R.id.loginadminname);
        password = (EditText) findViewById(R.id.loginadminpassword);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ns = name.getText().toString();
                String ps = password.getText().toString();

                if (ns.equals("admin") && ps.equals("admin")){
                    Intent intent = new Intent(LoginAdmin.this, AdminModule.class);
                    EmptyEditTextAfterDataInsert();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please Try again", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void EmptyEditTextAfterDataInsert(){

        name.getText().clear();

        password.getText().clear();

    }
}