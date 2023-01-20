package com.example.sps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sps.database.CompanyDatabase;

public class CompanyDetails extends AppCompatActivity {


    Button btnviewAll;
    CompanyDatabase myDb;

    public static final String Col_1 = "ID";
    public static final String Col_2 = "Name";
    public static final String Col_3 = "Surname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        getSupportActionBar().hide();

        btnviewAll = (Button) findViewById(R.id.cdetail);

        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SendNotification.sn == true) {
                SQLiteDatabase db = getApplicationContext().openOrCreateDatabase("CompanyDataBase.db", Context.MODE_PRIVATE, null);
                Cursor c = db.rawQuery("select * from " + myDb.TABLE_NAME, null);
                if (c.getCount() == 0){
                    Toast.makeText(getApplicationContext(),"No Data Found", Toast.LENGTH_LONG).show();
                }
                else {

                    StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        buffer.append("Name: " + c.getString(1) + "\n");
                        buffer.append("Description: " + c.getString(2) + "\n \n");
                    }

                    //Toast.makeText(getApplicationContext(), "All Companies: \n" + buffer.toString(),Toast.LENGTH_LONG).show();
                    showMessage("All Companies:", buffer.toString());
                }
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}