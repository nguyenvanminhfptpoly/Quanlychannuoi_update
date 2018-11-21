package com.minhnv.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.minhnv.admin88.quanlychannuoi.model.Dan;

import java.util.ArrayList;
import java.util.List;

public class DanDAO  {
    private SQLiteDatabase db;
    private Dan dan;

    public DanDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Dan dan){
        ContentValues values = new ContentValues();
        values.put("SOHIEUDAN",dan.getmSohieudan());
        values.put("SOLUONG",dan.getmSoluongdan());
        values.put("TINHTRANG",dan.getmTinhTrang());
        return db.insert("DAN",null,values);
    }
    public List<Dan> getAlldata(){
        List<Dan> list = new ArrayList<>();
        String sql = "select * from DAN ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String sohieudan = cursor.getString(cursor.getColumnIndex("SOHIEUDAN"));
            int soluong = cursor.getInt(cursor.getColumnIndex("SOLUONG"));
            String tinhtrang = cursor.getString(cursor.getColumnIndex("TINHTRANG"));
            list.add(new Dan(sohieudan,soluong,tinhtrang));
        }
        return list;
    }
    public int delete(Dan dan){
        return db.delete("DAN","SOHIEUDAN=?",new String[]{dan.getmSohieudan()});
    }

    public double getLuongCamTieuThu(){
        double diemtb = 0;
        String sql2 = " SELECT sum(SOLUONG*10)/count(sohieudan) FROM DAN    ";
        Cursor cursor2 = db.rawQuery(sql2,null);
        cursor2. moveToFirst();
        while (cursor2.isAfterLast()==false){
            diemtb= cursor2.getDouble(0);
            cursor2.moveToNext();
        }
        cursor2.close();
        return  diemtb;
    }
}
