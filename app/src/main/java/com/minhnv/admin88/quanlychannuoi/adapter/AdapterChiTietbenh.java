package com.minhnv.admin88.quanlychannuoi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minhnv.admin88.quanlychannuoi.base.ChiTietbenhActivity;
import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.model.ChitietBenh;

import java.util.ArrayList;
import java.util.List;

public class AdapterChiTietbenh extends RecyclerView.Adapter<AdapterChiTietbenh.ViewHodel> {
    private List<ChitietBenh> chitietBenhs;
    private Context context;

    public AdapterChiTietbenh(List<ChitietBenh> chitietBenhs, Context context) {
        this.chitietBenhs = chitietBenhs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.adapter_chitietbenh,parent,false);
        return new ViewHodel(v3, context, (ArrayList<ChitietBenh>) chitietBenhs);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.tv_tenbenh.setText(chitietBenhs.get(position).getmTenBenh());
        holder.tv_cachphong.setText(chitietBenhs.get(position).getmCachPhongTranh());
    }

    @Override
    public int getItemCount() {
        return chitietBenhs.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tv_tenbenh,tv_cachphong;
    ArrayList<ChitietBenh> chitietBenhs = new ArrayList<>();
    Context context;
        public ViewHodel(View itemView, Context context, ArrayList<ChitietBenh> chitietBenhs) {
            super(itemView);
            this.chitietBenhs = chitietBenhs;
            tv_tenbenh = itemView.findViewById(R.id.tv_tenbenhlon);
            tv_cachphong = itemView.findViewById(R.id.tv_phongchanh);
            itemView.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ChitietBenh chitiet = this.chitietBenhs.get(position);
            Intent intent = new Intent(this.context, ChiTietbenhActivity.class);
            intent.putExtra("tenbenh", chitiet.getmTenBenh());
            intent.putExtra("cachphong", chitiet.getmCachPhongTranh());
            context.startActivity(intent);
        }
    }
}
