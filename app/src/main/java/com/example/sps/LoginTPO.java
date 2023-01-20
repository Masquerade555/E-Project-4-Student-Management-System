package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sps.database.TpoDatabase;

public class LoginTPO extends AppCompatActivity {

    Button LogInButton;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    TpoDatabase sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_tpo);
        getSupportActionBar().hide();


        LogInButton = (Button)findViewById(R.id.logintposubmit);
        Password = (EditText)findViewById(R.id.logintpopassword);
        Email = (EditText)findViewById(R.id.logintponame);

        sqLiteHelper = new TpoDatabase(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();


            }
        });


    }

    public void EmptyEditTextAfterDataInsert(){


        Email.getText().clear();

        Password.getText().clear();

    }
    // Login function starts from here.
    public void LoginFunction(){

        if(EditTextEmptyHolder == true) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.rawQuery("SELECT * FROM " + sqLiteHelper.TABLE_NAME + " WHERE " + sqLiteHelper.Table_Column_1_Name + "=? AND " + sqLiteHelper.Table_Column_3_Password + "=?", new String[]{EmailHolder,PasswordHolder});

            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                //TempPassword = cursor.getString(cursor.getColumnIndex(sqLiteHelper.Table_Column_3_Password));

                // Closing cursor.
                cursor.close();

                CheckFinalResult();
            }
            else{
                Toast.makeText(LoginTPO.this,"Invalid UserName or Password",Toast.LENGTH_LONG).show();
            }

            // Calling method to check final result ..


        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(LoginTPO.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) ){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){



        Toast.makeText(LoginTPO.this,"Login Successful",Toast.LENGTH_LONG).show();

        // Going to Dashboard activity after login success message.
        Intent intent = new Intent(LoginTPO.this, TPOModule.class);
        EmptyEditTextAfterDataInsert();

        // Sending Email to Dashboard Activity using intent.
        intent.putExtra(UserEmail, EmailHolder);

        startActivity(intent);




        TempPassword = "NOT_FOUND" ;

    }

}




