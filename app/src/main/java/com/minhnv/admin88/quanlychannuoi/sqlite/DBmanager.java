package com.minhnv.admin88.quanlychannuoi.sqlite;

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
                "SOHIEUDAN TEXT," +
                "CANNANG DOUBLE ," +
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
                "SOLUONG INTEGER," +
                "GIATHITLON DOUBLE)";
        String baocao = "CREATE TABLE BAOCAO (" +
                "THOIGIAN TEXT PRIMARY KEY," +
                "DOANHTHU DOUBLE," +
                "CHIPHITHUCAN DOUBLE" +
                ")";
        String user = "CREATE TABLE NGUOIDUNG (" +
                "NAME TEXT PRIMARY KEY," +
                "SDT TEXT," +
                "DIACHI TEXT)";
        db.execSQL(dan);
        db.execSQL(cathe);
        db.execSQL(thucan);
        db.execSQL(hoadon);
        db.execSQL(baocao);
        db.execSQL(user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BAOCAO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CATHE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DAN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HOADON);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_THUCAN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(db);
    }
}
