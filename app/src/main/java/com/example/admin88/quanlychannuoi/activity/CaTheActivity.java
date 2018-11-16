package com.example.admin88.quanlychannuoi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.adapter.Adapter_Cathe;
import com.example.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.example.admin88.quanlychannuoi.model.Cathe;
import com.example.admin88.quanlychannuoi.sqlite.CatheDAO;

import java.util.List;

public class CaTheActivity extends AppCompatActivity {
    RecyclerView recyclerview_cathe;
    Button btn_dan;
    private CatheDAO catheDAO;
    private Cathe cathe;
    private Adapter_Cathe adapter_cathe;
    private List<Cathe> cathes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_the);

        recyclerview_cathe = findViewById(R.id.recyclerview_cathe);
        recyclerview_cathe.setLayoutManager(new LinearLayoutManager(CaTheActivity.this));


        catheDAO = new CatheDAO(CaTheActivity.this);
        cathes = catheDAO.getAllata();
        adapter_cathe = new Adapter_Cathe(cathes, CaTheActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerview_cathe.setAdapter(adapter_cathe);
    }
    public void removeItem( int position){
        cathe = new Cathe();
        cathe = cathes.get(position);
        cathes.remove(position);
        catheDAO.delete(cathe);
        updatedata();
    }
    public void btn_dan(View view) {
        Intent intent = new Intent(CaTheActivity.this, DanActivity.class);
        startActivity(intent);
    }
    public void updatedata(){
        cathes.clear();
        cathes.addAll(catheDAO.getAllata());
        adapter_cathe.notifyDataSetChanged();
    }
}
