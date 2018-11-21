package com.minhnv.admin88.quanlychannuoi.activity;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.adapter.Adapter_Hoadon;
import com.minhnv.admin88.quanlychannuoi.adapter.Adapter_dan;
import com.minhnv.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.minhnv.admin88.quanlychannuoi.model.Dan;
import com.minhnv.admin88.quanlychannuoi.model.HoaDon;
import com.minhnv.admin88.quanlychannuoi.sqlite.DanDAO;
import com.minhnv.admin88.quanlychannuoi.sqlite.HoadonDAO;

import java.util.List;

public class HoaDonActivity extends AppCompatActivity {
    RecyclerView recyclerView_hoadon;
    FloatingActionButton fab_hoadon;
    private HoadonDAO hoadonDAO;
    private List<HoaDon> hoaDons;
    private Adapter_Hoadon adapter_hoadon;
    private HoaDon hoaDon;

    private List<Dan> dans;
    private Dan dan;
    private Adapter_dan adapter_dan;
    private DanDAO danDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        recyclerView_hoadon = findViewById(R.id.recyclerview_hoadon);
        fab_hoadon = findViewById(R.id.fab_hoadon);
        hoadonDAO = new HoadonDAO(HoaDonActivity.this);
        recyclerView_hoadon.setLayoutManager(new LinearLayoutManager(HoaDonActivity.this));

        hoaDons = hoadonDAO.getAlldata();
        adapter_hoadon = new Adapter_Hoadon(hoaDons, HoaDonActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView_hoadon.setAdapter(adapter_hoadon);

        fab_hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanDAO danDAO = new DanDAO(HoaDonActivity.this);
                dans = danDAO.getAlldata();
                ArrayAdapter<Dan> danArrayAdapter;
                danArrayAdapter = new ArrayAdapter<Dan>(HoaDonActivity.this, android.R.layout.simple_spinner_dropdown_item, dans);

                AlertDialog.Builder builder = new AlertDialog.Builder(HoaDonActivity.this);
                View v5 = getLayoutInflater().inflate(R.layout.dialog_hoadon,null);
                TextView  textView12 = (TextView) v5.findViewById(R.id.textView12);
                final EditText edMahoadon = (EditText) v5.findViewById(R.id.ed_mahoadon);
                final Spinner edSohieudanHoadon = (Spinner) v5.findViewById(R.id.ed_sohieudan_hoadon);
                final EditText  edSoluongHoadon = (EditText) v5.findViewById(R.id.ed_soluong_hoadon);
                final EditText edGiathitlon = (EditText) v5.findViewById(R.id.ed_giathitlon);
                Button btnHuyhoadon = (Button) v5.findViewById(R.id.btn_huyhoadon);
                Button  btnThemhoadon = (Button) v5.findViewById(R.id.btn_themhoadon);
                builder.setView(v5);
                final Dialog dialog = builder.create();
                dialog.show();
                edSohieudanHoadon.setAdapter(danArrayAdapter);
                edSohieudanHoadon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        edSohieudanHoadon.getItemAtPosition(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                btnHuyhoadon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnThemhoadon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mahd = edMahoadon.getText().toString();
                        String tendan = String.valueOf(edSohieudanHoadon.getSelectedItem());
                        int soluong = ParseInt(edSoluongHoadon.getText().toString());
                        double gia = ParseDouble(edGiathitlon.getText().toString());


                        if (mahd.isEmpty() && tendan.isEmpty()){
                            Toast.makeText(HoaDonActivity.this, "Vui lòng Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        }else {
                            hoadonDAO.insert(new HoaDon(mahd,tendan,soluong,gia));
                            Toast.makeText(HoaDonActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                            updatedata();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });

    }
    public void removeItem(int position){
        hoaDon = new HoaDon();
        hoaDon = hoaDons.get(position);
        hoaDons.remove(position);
        hoadonDAO.delete(hoaDon);
        updatedata();
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
        hoaDons.clear();
        hoaDons.addAll(hoadonDAO.getAlldata());
        adapter_hoadon.notifyDataSetChanged();
    }
}
