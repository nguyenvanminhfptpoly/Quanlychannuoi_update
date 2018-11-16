package com.example.admin88.quanlychannuoi.activitychitiet;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.activity.CaTheActivity;
import com.example.admin88.quanlychannuoi.adapter.Adapter_Cathe;
import com.example.admin88.quanlychannuoi.adapter.Adapter_dan;
import com.example.admin88.quanlychannuoi.model.Cathe;
import com.example.admin88.quanlychannuoi.model.Dan;
import com.example.admin88.quanlychannuoi.sqlite.CatheDAO;
import com.example.admin88.quanlychannuoi.sqlite.DanDAO;

import java.util.List;

public class ChitietDanActivity extends AppCompatActivity {
    private ImageView imageView2;
    private TextView tvSohieudanchitiet;
    private TextView tvSoluongchitiet;
    private TextView tvTinhtrangchitiet;
    private Button btnCathedacbiet;
    private Button btnXemcathe;
    private TextView textView15;
    private TextView textView26;
    private TextView textView27;

    private CatheDAO catheDAO;
    private Cathe cathe;
    private Adapter_Cathe adapter_cathe;
    private List<Cathe> cathes;

    private DanDAO danDAO;
    private Adapter_dan adapter_dan;
    private List<Dan> dans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_dan);
        danDAO = new DanDAO(ChitietDanActivity.this);
        catheDAO = new CatheDAO(ChitietDanActivity.this);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        tvSohieudanchitiet = (TextView) findViewById(R.id.tv_sohieudanchitiet);
        tvSoluongchitiet = (TextView) findViewById(R.id.tv_soluongchitiet);
        tvTinhtrangchitiet = (TextView) findViewById(R.id.tv_tinhtrangchitiet);
        btnCathedacbiet = (Button) findViewById(R.id.btn_cathedacbiet);
        btnXemcathe = (Button) findViewById(R.id.btn_xemcathe);

        btnXemcathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChitietDanActivity.this, CaTheActivity.class);
                startActivity(intent);
            }
        });

        tvSohieudanchitiet.setText(getIntent().getStringExtra("sohieudan"));
        tvSoluongchitiet.setText(getIntent().getStringExtra("soluong"));
        tvTinhtrangchitiet.setText(getIntent().getStringExtra("tinhtrang"));

        btnCathedacbiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChitietDanActivity.this);
                View v2 = getLayoutInflater().inflate(R.layout.dialog_cathe,null);

                TextView textView13 = (TextView) v2.findViewById(R.id.textView13);
                final EditText edSohieudancathe =  v2.findViewById(R.id.ed_sohieudancathe);
                final EditText edSohieucathe = (EditText) v2.findViewById(R.id.ed_sohieucathe);
                final EditText edGiong = (EditText) v2.findViewById(R.id.ed_giong);
                final EditText edCannang = (EditText) v2.findViewById(R.id.ed_cannang);
                final EditText edTinhtranglon = (EditText) v2.findViewById(R.id.ed_tinhtranglon);
                final EditText   edTenbenh = (EditText) v2.findViewById(R.id.ed_tenbenh);
                final EditText  edXuatchuong = (EditText) v2.findViewById(R.id.ed_xuatchuong);
                Button   btnThemcathe = (Button) v2.findViewById(R.id.btn_themcathe);
                Button   huy = (Button) v2.findViewById(R.id.btnhuycathe);

                edSohieudancathe.setText(getIntent().getStringExtra("sohieudan"));
                builder.setView(v2);
                final Dialog dialog = builder.create();
                dialog.show();
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnThemcathe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sohieucathe = edSohieucathe.getText().toString();
                        String edsohieudanct = edSohieudancathe.getText().toString();
                        double cannag2 = ParseDouble(edCannang.getText().toString());
                        String giong = edGiong.getText().toString();
                        String tinhtrang = edTinhtranglon.getText().toString();
                        String tenbenh  = edTenbenh.getText().toString();
                        String xuat = edXuatchuong.getText().toString();


                        if (sohieucathe.isEmpty() && edsohieudanct.isEmpty() && giong.isEmpty()  && tinhtrang.isEmpty() && tenbenh.isEmpty() && xuat.isEmpty()){
                            Toast.makeText(ChitietDanActivity.this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        }else {
                            catheDAO.insert(new Cathe(edsohieudanct,giong,tinhtrang,tenbenh,xuat,sohieucathe,cannag2));
                            Toast.makeText(ChitietDanActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ChitietDanActivity.this, CaTheActivity.class);
                            startActivity(intent);
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
}
