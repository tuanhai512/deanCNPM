package com.example.doancmpm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelperSearch extends SQLiteOpenHelper {
    //Tên cơ wro dữ liệu
    private static final String TEN_DATABASE = "QuanLyThuVien";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "_id";
    // Cac bang
    private static final String TABLE_SACH = "TSach";
    private static final String KEY_TENSACH = "tenSach";


    private Context context;
    private SQLiteDatabase db;

    public DBHelperSearch(Context context) {
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

    public List<Book> FindAll() {
        List<Book> books = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_SACH, null);
            if (cursor.moveToFirst()) {
                books = new ArrayList<Book>();
                do {
                    Book book = new Book();
                    book.set_tenSach(cursor.getString(0));

                    books.add(book);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            books = null;
        }
        return books;
    }

    public List<Book> Search(String keyword) {
        List<Book> books = new ArrayList<>();
        String chuVietThuong = keyword.toLowerCase();
        try {

            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            String query = "select * from " + TABLE_SACH +
                    " where " + "LOWER(" + KEY_TENSACH + ")" + " LIKE " + "'%" + keyword + "%'";

            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                books = new ArrayList<Book>();
                do {
                    int viTriCotTenSach = cursor.getColumnIndex(KEY_TENSACH);
                    String tenSach = cursor.getString(viTriCotTenSach);
                    Book book = new Book(tenSach);
                    books.add(book);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            books = null;
        }
        return books;
    }


}
