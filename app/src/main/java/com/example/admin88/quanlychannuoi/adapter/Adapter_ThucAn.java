package com.example.admin88.quanlychannuoi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.example.admin88.quanlychannuoi.model.ThucAn;
import com.example.admin88.quanlychannuoi.sqlite.ThucAnDAO;

import java.util.List;

public class Adapter_ThucAn extends RecyclerView.Adapter<Adapter_ThucAn.ViewHodel>{
    private List<ThucAn> thucAns;
    private Context context;
    private OnitemDeleteDan onitemDeleteDan;
    private ThucAnDAO thucAnDAO;

    public Adapter_ThucAn(List<ThucAn> thucAns, Context context,OnitemDeleteDan onitemDeleteDan) {
        this.thucAns = thucAns;
        this.context = context;
        this.onitemDeleteDan = onitemDeleteDan;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.item_thucan,parent,false);
        return new ViewHodel(v3,onitemDeleteDan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
        thucAnDAO = new ThucAnDAO(context);
        holder.tvDongia.setText(thucAns.get(position).getmDongiathucan()+"");
        holder.tvDot.setText(thucAns.get(position).getmDot());
        holder.tvSoluongthucan.setText(thucAns.get(position).getmSoluongthucan()+"");
        holder.imgDeleteThucan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemDeleteDan.onItemdelete(position);
            }
        });
        int soluong = Integer.parseInt(holder.tvSoluongthucan.getText().toString());
        double dongia = Double.parseDouble(holder.tvDongia.getText().toString());

        double thanhtien = soluong * dongia;
        holder.tvTongchiphithucan.setText(String.valueOf(thanhtien));
    }

    @Override
    public int getItemCount() {
        return thucAns.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{

        public TextView tvDot;
        public TextView tvSoluongthucan;
        public TextView tvDongia;
        public TextView tvTongchiphithucan;
        public ImageView imgDeleteThucan;

        public ViewHodel(View itemView,OnitemDeleteDan onitemDeleteDan) {
            super(itemView);

            tvDot = (TextView) itemView.findViewById(R.id.tv_dot);
            tvSoluongthucan = (TextView) itemView.findViewById(R.id.tv_soluongthucan);
            tvDongia = (TextView) itemView.findViewById(R.id.tv_dongia);
            tvTongchiphithucan = (TextView) itemView.findViewById(R.id.tv_tongchiphithucan);
            imgDeleteThucan = (ImageView) itemView.findViewById(R.id.img_delete_thucan);
        }
    }
}
