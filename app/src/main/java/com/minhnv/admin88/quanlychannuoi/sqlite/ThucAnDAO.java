package com.minhnv.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.minhnv.admin88.quanlychannuoi.model.ThucAn;

import java.util.ArrayList;
import java.util.List;

public class ThucAnDAO {
    private SQLiteDatabase db;
    private ThucAn thucAn;

    public ThucAnDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }

    public long insert(ThucAn thucAn){
        ContentValues values = new ContentValues();
        values.put("DOT",thucAn.getmDot());
        values.put("SOLUONG",thucAn.getmSoluongthucan());
        values.put("DONGIA",thucAn.getmDongiathucan());
        return db.insert("THUCAN",null,values);
    }
    public List<ThucAn> getAlldata(){
        List<ThucAn> list = new ArrayList<>();
        String sql = "select * from THUCAN ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String dot = cursor.getString(cursor.getColumnIndex("DOT"));
            int soluongthucan = cursor.getInt(cursor.getColumnIndex("SOLUONG"));
            double dongia = cursor.getDouble(cursor.getColumnIndex("DONGIA"));
            list.add(new ThucAn(dot,soluongthucan,dongia));
        }
        return list;
    }
    public int delete(ThucAn thucAn){
        return db.delete("THUCAN","DOT=?", new String[]{thucAn.getmDot()});
    }
    public double getChiPhithucan(){
        double diemtb = 0;
        String sql2 = " SELECT (SOLUONG*DONGIA) FROM THUCAN  ";
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
