package com.example.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.quanlychannuoi.model.BaoCao;

import java.util.ArrayList;
import java.util.List;

public class BaoCaoDAO {
    SQLiteDatabase db;
    private BaoCao baoCao;

    public BaoCaoDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(BaoCao baoCao){
        ContentValues values = new ContentValues();
        values.put("THOIGIAN", baoCao.getmTimeBaoCao());
        values.put("DOANHTHU", baoCao.getmDoanhthu());
        values.put("CHIPHITHUCAN", baoCao.getmChiPhi());
        return db.insert("BAOCAO",null,values);
    }
    public List<BaoCao> getAlldata(){
        List<BaoCao> list = new ArrayList<>();
        String sql  = "select * from BAOCAO ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String thoigian = cursor.getString(cursor.getColumnIndex("THOIGIAN"));
            double doanhthu = cursor.getDouble(cursor.getColumnIndex("DOANHTHU"));
            double chiphi = cursor.getDouble(cursor.getColumnIndex("CHIPHITHUCAN"));
            list.add(new BaoCao(thoigian,doanhthu,chiphi));
        }
        return list;
    }
    public int delete(BaoCao baoCao){
        return db.delete("BAOCAO","THOIGIAN=?",new String[]{baoCao.getmTimeBaoCao()});
    }
}
