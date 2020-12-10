package com.example.doancmpm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelperTK extends SQLiteOpenHelper {
    private static final String TEN_DATABASE = "QuanLyThuVien";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "_id";
    // Cac bang
    private static final String TABLE_TAIKHOAN = "TK";
    private static final String KEY_ACCOUNT = "_account";
    private static final String KEY_PASS = "_pass";

    public DatabaseHelperTK(Context context) {
        super(context, TEN_DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " + TABLE_TAIKHOAN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ACCOUNT + " TEXT,"
                + KEY_PASS + " TEXT" + ");";
        db.execSQL(CREATE_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /*public void insert(Account account)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ACCOUNT,account.get_account());
        values.put(KEY_PASS,account.get_pass());


        db.insert(TABLE_TAIKHOAN,null,values);
        db.close();
    }*/

    public Boolean insert(String s1, String s2) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ACCOUNT, s1);
        values.put(KEY_PASS, s2);
        long ins = db.insert(TABLE_TAIKHOAN, null, values);
        if (ins == -1) return false;
        else return true;
    }

    public Boolean checkTK(String _account) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_TAIKHOAN + " WHERE " + KEY_ACCOUNT + " = ?" ;
        Cursor cursor = db.rawQuery(query, new String[]{_account});
        if (cursor.getCount() > 0)
            return false;
        else return true;
    }
    public Boolean CheckDangNhap(String _account, String _pass)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_TAIKHOAN + " WHERE " + KEY_ACCOUNT + " = ?" + "AND " + KEY_PASS + " = ?" ;
        Cursor cursor = db.rawQuery(query, new String[]{_account,_pass});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
}
