package com.example.sps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SDatabase extends SQLiteOpenHelper {


    static String DATABASE_NAME = "StudentD";

    public static final String TABLE_NAME = "StudentTable";

    public static final String Table_Column_ID = "id";

    public static final String Table_Column_1_Name = "name";

    public static final String Table_Column_2_Branch = "branch";

    public static final String Table_Column_3_Percentage = "percentage";



    public SDatabase(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Name + " VARCHAR, " + Table_Column_2_Branch + " VARCHAR, " + Table_Column_3_Percentage + " VARCHAR, " + Table_Column_3_Selected + " VARCHAR );";
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Name + " VARCHAR, " + Table_Column_2_Branch + " VARCHAR, " + Table_Column_3_Percentage + " VARCHAR );";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
