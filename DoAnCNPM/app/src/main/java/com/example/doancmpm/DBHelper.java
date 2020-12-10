package com.example.doancmpm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    //Tên cơ wro dữ liệu
    private static final String TEN_DATABASE = "QuanLyThuVien";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "_id";
    // Cac bang
    private static final String TABLE_SACH = "TSach";
    private static final String KEY_TENSACH = "tenSach";



    private Context context;
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBangSach = "CREATE TABLE " + TABLE_SACH + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TENSACH + " TEXT)";
        db.execSQL(taoBangSach);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public List<Book> LayTatCaSach() {
        SQLiteDatabase db = getWritableDatabase();
        List<Book> tatCaSach = new ArrayList<>();
        Cursor sachs = db.query
                (TABLE_SACH, null, null, null, null, null, null);
        if (sachs.getCount() > 0) {
            sachs.moveToFirst();
            do {
                String tenSach = sachs.getString(sachs.getColumnIndex(KEY_TENSACH));

                Book book = new Book(tenSach);
                tatCaSach.add(book);
            } while (sachs.moveToNext());
        }
        return tatCaSach;
    }


    public void ThemSach(Book sach) {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TENSACH,sach.get_tenSach());

        db.insert(TABLE_SACH,null,values);
        db.close();
    }
}
