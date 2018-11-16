package com.example.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.quanlychannuoi.model.Cathe;

import java.util.ArrayList;
import java.util.List;

public class CatheDAO {
    private SQLiteDatabase db;
    private Cathe cathe;

    public CatheDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Cathe cathe){
        ContentValues values = new ContentValues();
        values.put("SOHIEUCATHE", cathe.getmSohieucathe());
        values.put("SOHIEUDAN", cathe.getmSohieudan());
        values.put("CANNANG",cathe.getmCannang());
        values.put("GIONG", cathe.getmGiong());
        values.put("TINHTRANGCATHE",cathe.getmTinhtranglon());
        values.put("TENBENH",cathe.getmTenbenh());
        values.put("XUATCHUONG",cathe.getmXuatchuong());
        return db.insert("CA_THE",null,values);
    }
    public List<Cathe> getAllata(){
        List<Cathe> list = new ArrayList<>();
        String sql = "select * from CA_THE ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String sohieucathe = cursor.getString(cursor.getColumnIndex("SOHIEUCATHE"));
            String sohieudan = cursor.getString(cursor.getColumnIndex("SOHIEUDAN"));
            double CANNANG = cursor.getDouble(cursor.getColumnIndex("CANNANG"));
            String GIONG = cursor.getString(cursor.getColumnIndex("GIONG"));
            String TINHTRANGCATHE = cursor.getString(cursor.getColumnIndex("TINHTRANGCATHE"));
            String TENBENH = cursor.getString(cursor.getColumnIndex("TENBENH"));
            String XUATCHUONG = cursor.getString(cursor.getColumnIndex("XUATCHUONG"));
            list.add(new Cathe(sohieudan,GIONG,TINHTRANGCATHE,TENBENH,XUATCHUONG,sohieucathe,CANNANG));
        }
        return list;
    }

    public int delete(Cathe cathe){
        return db.delete("CA_THE","SOHIEUCATHE=?",new String[]{cathe.getmSohieucathe()});
    }
}
