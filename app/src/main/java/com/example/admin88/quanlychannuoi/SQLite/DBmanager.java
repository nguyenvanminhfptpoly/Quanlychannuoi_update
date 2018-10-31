package com.example.admin88.quanlychannuoi.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmanager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QUAN_LY_CHAN_NUOI";
    public static final String TABLE_CATHE = "CA_THE";
    public static final String TABLE_DAN = "DAN";
    public static final String TABLE_HOADON = "HOADON";
    public static final String TABLE_BAOCAO = "BAOCAO";
    public static final String TABLE_USER = "NGUOIDUNG";
    public static final String TABLE_THUCAN = "THUCAN";
    public static final String ID = "ID";
    public DBmanager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dan = "CREATE TABLE DAN (" +
                "SOHIEUDAN TEXT PRIMARY KEY," +
                "SOLUONG INTEGER," +
                "TINHTRANG TEXT)";
        String cathe = "CREATE TABLE CA_THE (" +
                "SOHIEUCATHE TEXT PRIMARY KEY," +
                "SOHIEUDAN TEXT" +
                "CANNANG DOUBLE," +
                "GIONG TEXT," +
                "TINHTRANGCATHE TEXT," +
                "TENBENH TEXT," +
                "XUATCHUONG TEXT," +
                "FOREIGN KEY (SOHIEUDAN) REFERENCES DAN)";
        String thucan = "CREATE TABLE THUCAN (" +
                "DOT TEXT PRIMARY KEY," +
                "SOLUONG INTEGER," +
                "DONGIA DOUBLE) ";
        String hoadon = "CREATE TABLE HOADON (" +
                "MAHOADON TEXT PRIMARY KEY," +
                "SOHIEUDAN TEXT," +
                ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
