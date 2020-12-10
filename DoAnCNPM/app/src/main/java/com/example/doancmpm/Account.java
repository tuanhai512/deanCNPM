package com.example.doancmpm;

public class Account {
    private int _id;
    public String _account;
    public String _pass;
    public Account()
    {

    }
    public Account(int _id, String _account, String _pass)
    {
        this._id = _id;
        this._account = _account;
        this._pass = _pass;
    }
    public Account(String _account, String _pass)
    {
        this._account = _account;
        this._pass = _pass;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_account() {
        return _account;
    }

    public void set_account(String _account) {
        this._account = _account;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }
}
