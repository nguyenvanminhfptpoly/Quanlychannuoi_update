package com.minhnv.admin88.quanlychannuoi.activity;

import android.app.Dialog;
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

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.adapter.Adapter_baocao;
import com.minhnv.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.minhnv.admin88.quanlychannuoi.model.BaoCao;
import com.minhnv.admin88.quanlychannuoi.sqlite.BaoCaoDAO;

import java.util.List;

public class BaoCaoActivity extends AppCompatActivity {
    RecyclerView ryc_baocao;
    FloatingActionButton fab_baocao;
    private BaoCaoDAO baoCaoDAO;
    private BaoCao baoCao;
    private List<BaoCao> baoCaos;
    private Adapter_baocao adapter_baocao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        ryc_baocao = findViewById(R.id.recyclerview_baocao);
        fab_baocao = findViewById(R.id.fab_baocao);
        ryc_baocao.setLayoutManager(new LinearLayoutManager(BaoCaoActivity.this));

        baoCaoDAO = new BaoCaoDAO(BaoCaoActivity.this);

        baoCaos = baoCaoDAO.getAlldata();
        adapter_baocao = new Adapter_baocao(baoCaos, BaoCaoActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeitem(position);
            }
        });
        ryc_baocao.setAdapter(adapter_baocao);


        fab_baocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(BaoCaoActivity.this);
                View v5 = getLayoutInflater().inflate(R.layout.dialog_baocao,null);
                TextView textView12 = (TextView) v5.findViewById(R.id.textView12);
                final EditText edTime = (EditText) v5.findViewById(R.id.ed_time);
                final EditText edDoanhthu = (EditText) v5.findViewById(R.id.ed_doanhthu);
                final EditText edChiphichannuoi = (EditText) v5.findViewById(R.id.ed_chiphichannuoi);
                Button btnHuybaocao = (Button) v5.findViewById(R.id.btn_huybaocao);
                Button btnThembaocao = (Button) v5.findViewById(R.id.btn_thembaocao);
                builder.setView(v5);
                final Dialog dialog = builder.create();
                dialog.show();


                btnHuybaocao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnThembaocao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String thoigian = edTime.getText().toString();
                        double doanhthu = ParseDouble(edDoanhthu.getText().toString());
                        double chiphi = ParseDouble(edChiphichannuoi.getText().toString());
                        if (thoigian.isEmpty()){
                            Toast.makeText(BaoCaoActivity.this, "Vui lòng Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        }else {
                            baoCaoDAO.insert(new BaoCao(thoigian,doanhthu,chiphi));
                            Toast.makeText(BaoCaoActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                            updatedata();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
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
        baoCaos.clear();
        baoCaos.addAll(baoCaoDAO.getAlldata());
        adapter_baocao.notifyDataSetChanged();
    }
    public void removeitem(int position){
        baoCao = new BaoCao();
        baoCao = baoCaos.get(position);
        baoCaos.remove(position);
        baoCaoDAO.delete(baoCao);
        updatedata();
    }
}
