package com.minhnv.admin88.quanlychannuoi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.minhnv.admin88.quanlychannuoi.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private SQLiteDatabase db;
    private User user;
    public UserDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(User user){
        ContentValues values = new ContentValues();
        values.put("NAME",user.getmName());
        values.put("SDT",user.getmSdt());
        values.put("DIACHI",user.getmAddress());
        return  db.insert("NGUOIDUNG",null,values);
    }
    public List<User> getAlldata(){
        List<User> list = new ArrayList<>();
        String sql = "select * from NGUOIDUNG ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String diachi = cursor.getString(cursor.getColumnIndex("DIACHI"));
            String sdt = cursor.getString(cursor.getColumnIndex("SDT"));
            list.add(new User(name,diachi,sdt));
        }
        return list;
    }
    public int delete(User user){
        return db.delete("NGUOIDUNG","NAME=?",new String[]{user.getmName()});
    }
}
