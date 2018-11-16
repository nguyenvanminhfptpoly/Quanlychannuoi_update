package com.example.admin88.quanlychannuoi.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.adapter.Adapter_Cathe;
import com.example.admin88.quanlychannuoi.adapter.Adapter_dan;
import com.example.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.example.admin88.quanlychannuoi.model.Cathe;
import com.example.admin88.quanlychannuoi.model.Dan;
import com.example.admin88.quanlychannuoi.sqlite.CatheDAO;
import com.example.admin88.quanlychannuoi.sqlite.DanDAO;

import java.util.List;

public class DanActivity extends AppCompatActivity {
    RecyclerView recyclerview_dan;
    FloatingActionButton fab_dan;
    private List<Dan> dans;
    private Dan dan;
    private Adapter_dan adapter_dan;
    private DanDAO danDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan);
        danDAO = new DanDAO(DanActivity.this);
        recyclerview_dan = findViewById(R.id.recyclerview_dan);
        fab_dan = findViewById(R.id.fab_dan);
        recyclerview_dan.setLayoutManager(new LinearLayoutManager(DanActivity.this));


        //themvaoryc
        dans = danDAO.getAlldata();
        adapter_dan = new Adapter_dan(dans, DanActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeitem(position);
            }
        });
        recyclerview_dan.setAdapter(adapter_dan);

        //batsukien
        fab_dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DanActivity.this);
                View v2 = getLayoutInflater().inflate(R.layout.dialog_them_dan,null);
                final EditText ed_sohieudan = v2.findViewById(R.id.ed_sohieudan);
                final EditText ed_soluong = v2.findViewById(R.id.ed_soluongdan);
                final EditText ed_tinhtrang = v2.findViewById(R.id.ed_tinhtrang);
                Button btn_them = v2.findViewById(R.id.btn_themdan);
                Button huy = v2.findViewById(R.id.btnhuydan);
                builder.setView(v2);
                final Dialog dialog = builder.create();
                dialog.show();
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btn_them.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sohieudan = ed_sohieudan.getText().toString();
                        String tinhtrang = ed_tinhtrang.getText().toString();
                        int soluong = ParseDouble(ed_soluong.getText().toString());
                         if(sohieudan.equals("")&& tinhtrang.equals("")){
                             Toast.makeText(DanActivity.this, "Vui Lòng Nhập đủ Dữ Liệu", Toast.LENGTH_SHORT).show();
                         }else {
                             danDAO.insert(new Dan(sohieudan,soluong,tinhtrang));
                             Toast.makeText(DanActivity.this, "Thêm Thành công", Toast.LENGTH_SHORT).show();
                                updatedata();
                                dialog.dismiss();
                         }
                    }
                });
            }
        });
    }
    public void updatedata(){
        dans.clear();
        dans.addAll(danDAO.getAlldata());
        adapter_dan.notifyDataSetChanged();
    }
    public void thucanchodan(View view) {
        Intent intent = new Intent(DanActivity.this, ThucAnActivity.class);
        startActivity(intent);
    }
    public int ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Integer.parseInt(strNumber);
            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else {
            Toast.makeText(this, "Vui Lòng Nhập đủ Dữ Liệu", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
    public void removeitem(int position){
        dan = new Dan();
        dan = dans.get(position);
        dans.remove(position);
        danDAO.delete(dan);
        updatedata();
    }

}
