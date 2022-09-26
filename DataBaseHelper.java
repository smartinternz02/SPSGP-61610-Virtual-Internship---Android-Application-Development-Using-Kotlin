package com.example.loginanddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USER_RECORD.db";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDb) {

        myDb.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,EMAIL TEXT,PASSWORD TEXT)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase myDb, int oldVersion, int newVersion) {
        myDb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(myDb);

    }

    public boolean registerUser(String USERNAME, String EMAIL, String PASSWORD) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, USERNAME);
        contentValues.put(COL_3, EMAIL);
        contentValues.put(COL_4, PASSWORD);
        long result = myDb.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUser(String USERNAME, String PASSWORD) {
        SQLiteDatabase myDb = this.getWritableDatabase();

        Cursor cursor = myDb.rawQuery("select * from USER_DATA where USERNAME = ? and PASSWORD = ?", new String[]{USERNAME, PASSWORD});
        int count = cursor.getCount();

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean check(String USERNAME) {
        SQLiteDatabase myDb = this.getWritableDatabase();

        Cursor cursor = myDb.rawQuery("select * from USER_DATA where USERNAME = ?", new String[]{USERNAME});
        int count = cursor.getCount();

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
