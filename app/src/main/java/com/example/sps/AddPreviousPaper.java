package com.example.sps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sps.database.PreviousPaperDatabase;
import com.example.sps.database.SDatabase;

public class AddPreviousPaper extends AppCompatActivity {

    EditText  Name, Paper;
    Button Register;
    String NameHolder, PaperHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    PreviousPaperDatabase sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    public static boolean sn = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_previous_paper);
        getSupportActionBar().hide();


        Register = (Button) findViewById(R.id.addppsubmit);
        Paper = (EditText) findViewById(R.id.addppfile);
        Name = (EditText) findViewById(R.id.addppname);

        sqLiteHelper = new PreviousPaperDatabase(this);

        // Adding click listener to register button.
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                //SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                //SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                //EmptyEditTextAfterDataInsert();


            }
        });



    }



    public void InsertDataIntoSQLiteDatabase() {

        // If editText is not empty then this block will executed.
        if (EditTextEmptyHolder == true) {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + sqLiteHelper.TABLE_NAME + " (name,file) VALUES('" + NameHolder + "', '" + PaperHolder +  "' );";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            EmptyEditTextAfterDataInsert();

            // Printing toast message after done inserting.
            Toast.makeText(AddPreviousPaper.this, "Paper Added Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(AddPreviousPaper.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert() {

        Name.getText().clear();
        Paper.getText().clear();
        sn = true;

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus() {

        // Getting value from All EditText and storing into String Variables.
        NameHolder = Name.getText().toString();
        PaperHolder = Paper.getText().toString();

        if (TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(PaperHolder)) {

            EditTextEmptyHolder = false;

        } else {

            EditTextEmptyHolder = true;
        }
    }

    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot() {

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(sqLiteHelper.TABLE_NAME, null, " " + sqLiteHelper.Table_Column_1_Name + "=?", new String[]{NameHolder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }


    // Checking result
    public void CheckFinalResult() {

        // Checking whether email is already exists or not.
        if (F_Result.equalsIgnoreCase("Paper Found")) {

            // If email is exists then toast msg will display.
            Toast.makeText(AddPreviousPaper.this, "Paper Already Exists", Toast.LENGTH_LONG).show();

        } else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();


        }

        F_Result = "Not_Found";

    }
}



