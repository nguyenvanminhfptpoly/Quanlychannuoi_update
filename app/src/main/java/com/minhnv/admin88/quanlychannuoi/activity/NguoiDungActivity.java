package com.minhnv.admin88.quanlychannuoi.activity;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.adapter.Adapter_User;
import com.minhnv.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.minhnv.admin88.quanlychannuoi.model.User;
import com.minhnv.admin88.quanlychannuoi.sqlite.UserDAO;

import java.util.List;

public class NguoiDungActivity extends AppCompatActivity {
    private RecyclerView rycNguoidung;
    private FloatingActionButton fabUser;
    private UserDAO userDAO;
    private Adapter_User adapter_user;
    private User user;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        rycNguoidung = (RecyclerView) findViewById(R.id.ryc_nguoidung);
        fabUser = (FloatingActionButton) findViewById(R.id.fab_user);

        rycNguoidung.setLayoutManager(new LinearLayoutManager(NguoiDungActivity.this));

        userDAO = new UserDAO(NguoiDungActivity.this);
        users = userDAO.getAlldata();
        adapter_user = new Adapter_User(users, NguoiDungActivity.this, new OnitemDeleteDan() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        rycNguoidung.setAdapter(adapter_user);

        fabUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NguoiDungActivity.this);
                View v5 = getLayoutInflater().inflate(R.layout.dialog_user,null);
                TextView textView12 = (TextView) v5.findViewById(R.id.textView12);
                final EditText edNameuser = (EditText) v5.findViewById(R.id.ed_nameuser);
                final EditText edSdt = (EditText) v5.findViewById(R.id.ed_sdt);
                final EditText edDiachi = (EditText) v5.findViewById(R.id.ed_diachi);
                Button btnHuyuser = (Button) v5.findViewById(R.id.btn_huyuser);
                Button btnThemuser = (Button) v5.findViewById(R.id.btn_themuser);
                builder.setView(v5);
                final Dialog dialog = builder.create();
                dialog.show();

                PhoneNumberUtils.formatNumber(edSdt.getText().toString());

                btnHuyuser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnThemuser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edNameuser.getText().toString();
                        String diachi = edDiachi.getText().toString();
                        String sdt = edSdt.getText().toString();

                        if (name.isEmpty() && diachi.isEmpty()){
                            Toast.makeText(NguoiDungActivity.this, "Vui lòng Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        }else {
                            userDAO.insert(new User(name,diachi,sdt));
                            Toast.makeText(NguoiDungActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                            updatedata();
                            dialog.dismiss();
                        }
                    }
                });
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
    public void updatedata(){
        users.clear();
        users.addAll(userDAO.getAlldata());
        adapter_user.notifyDataSetChanged();
    }
    public void removeItem(int position){
        user = new User();
        user = users.get(position);
        users.remove(position);
        userDAO.delete(user);
        updatedata();
    }
}
