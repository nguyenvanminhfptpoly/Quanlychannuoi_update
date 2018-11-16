package com.example.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.quanlychannuoi.model.Cathe;
import com.example.admin88.quanlychannuoi.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoadonDAO {
    private SQLiteDatabase db;
    private HoaDon hoaDon;

    public HoadonDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("MAHOADON", hoaDon.getmMahoadon());
        values.put("SOHIEUDAN",hoaDon.getmTenDan_hoadon());
        values.put("SOLUONG",hoaDon.getmSoluongHoadon());
        values.put("GIATHITLON",hoaDon.getmGiaThitLon());
        return db.insert("HOADON",null,values);
    }
    public List<HoaDon> getAlldata(){
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from HOADON ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String mahoadon = cursor.getString(cursor.getColumnIndex("MAHOADON"));
            String sohieudan = cursor.getString(cursor.getColumnIndex("SOHIEUDAN"));
            int soluong = cursor.getInt(cursor.getColumnIndex("SOLUONG"));
            double gia = cursor.getDouble(cursor.getColumnIndex("GIATHITLON"));
            list.add(new HoaDon(mahoadon,sohieudan,soluong,gia));
        }
        return list;
    }
    public int delete(HoaDon hoaDon){
        return db.delete("HOADON","MAHOADON=?",new String[]{hoaDon.getmMahoadon()});
    }
    public double getChiPhithucan(){
        double diemtb = 0;
        String sql2 = " SELECT (GIATHITLON*(SOLUONG*100)) FROM HOADON  ";
        Cursor cursor2 = db.rawQuery(sql2,null);
        cursor2.moveToFirst();
        while (cursor2.isAfterLast()==false){
            diemtb= cursor2.getDouble(0);
            cursor2.moveToNext();
        }
        cursor2.close();
        return  diemtb;
    }
}
