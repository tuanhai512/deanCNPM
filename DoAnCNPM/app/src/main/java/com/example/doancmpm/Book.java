package com.example.doancmpm;

public class Book {

    private int _id;

    public Book() {
    }


    private String _tenSach;

    public Book(int _id, String _tenSach) {
        this._id = _id;

        this._tenSach = _tenSach;
    }

    public Book( String _tenSach) {

        this._tenSach = _tenSach;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String get_tenSach() {
        return _tenSach;
    }

    public void set_tenSach(String _tenSach) {
        this._tenSach = _tenSach;
    }
}
