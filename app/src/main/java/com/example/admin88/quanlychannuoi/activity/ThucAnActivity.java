package com.example.admin88.quanlychannuoi.activity;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.adapter.Adapter_ThucAn;
import com.example.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.example.admin88.quanlychannuoi.model.ThucAn;
import com.example.admin88.quanlychannuoi.sqlite.ThucAnDAO;

import java.util.List;

public class ThucAnActivity extends AppCompatActivity {
    private RecyclerView ryc_thucan;
    private ThucAnDAO thucAnDAO;
    private List<ThucAn> thucAns;
    private Adapter_ThucAn adapter_thucAn;
    private ThucAn thucAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_an);
        ryc_thucan = findViewById(R.id.recyclerview_thucan);
        ryc_thucan.setLayoutManager(new LinearLayoutManager(ThucAnActivity.this));

        thucAnDAO = new ThucAnDAO(ThucAnActivity.this);
        thucAns = thucAnDAO.getAlldata();
        adapter_thucAn = new Adapter_ThucAn(thucAns, ThucAnActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeitem(position);
            }
        });
        ryc_thucan.setAdapter(adapter_thucAn);
    }
    public void removeitem(int position){
        thucAn = new ThucAn();
        thucAn = thucAns.get(position);
        thucAns.remove(position);
        thucAnDAO.delete(thucAn);
        updatedata();
    }
    public void themthucan(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ThucAnActivity.this);
        View v = getLayoutInflater().inflate(R.layout.dialog_thucan,null);
        final EditText dotthucan = v.findViewById(R.id.ed_dot);
        final EditText soluongthucan = v.findViewById(R.id.ed_soluong);
        final EditText dongiathucan = v.findViewById(R.id.ed_dongia);
        Button btn_huy = v.findViewById(R.id.btn_huythucan);
        Button btn_them = v.findViewById(R.id.btn_themthucan);
        builder.setView(v);
        final Dialog dialog = builder.create();
        dialog.show();


        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dot = dotthucan.getText().toString();
                int soluong = ParseInt(soluongthucan.getText().toString());
                double dongia = ParseDouble(dongiathucan.getText().toString());
                if (dot.isEmpty()){
                    Toast.makeText(ThucAnActivity.this, "Vui lòng Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }else {
                    thucAnDAO.insert(new ThucAn(dot,soluong,dongia));
                    Toast.makeText(ThucAnActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    updatedata();
                    dialog.dismiss();
                }
            }
        });
    }
    public int ParseInt(String strNumber) {
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
    public double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else {
            Toast.makeText(this, "Vui Lòng Nhập đủ Dữ Liệu", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
    public void updatedata(){
        thucAns.clear();
        thucAns.addAll(thucAnDAO.getAlldata());
        adapter_thucAn.notifyDataSetChanged();
    }
}
