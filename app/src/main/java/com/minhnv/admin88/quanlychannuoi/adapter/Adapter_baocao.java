package com.minhnv.admin88.quanlychannuoi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.minhnv.admin88.quanlychannuoi.model.BaoCao;

import java.util.List;

public class Adapter_baocao extends RecyclerView.Adapter<Adapter_baocao.ViewHodel> {
    private List<BaoCao> baoCaos;
    private Context context;
    private OnitemDeleteDan onitemDeleteDan;

    public Adapter_baocao(List<BaoCao> baoCaos, Context context, OnitemDeleteDan onitemDeleteDan) {
        this.baoCaos = baoCaos;
        this.context = context;
        this.onitemDeleteDan = onitemDeleteDan;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.item_baocao,parent,false);
        return new ViewHodel(v3);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
        holder.tvChiphiBaocao.setText(baoCaos.get(position).getmChiPhi()+"");
        holder.tvDoanhthuBaocao.setText(baoCaos.get(position).getmDoanhthu()+"");
        holder.tvThoigianBaocao.setText(baoCaos.get(position).getmTimeBaoCao());
        holder.imgDeleteBaocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemDeleteDan.onItemdelete(position);
            }
        });

        double tongdoanhthu = Double.parseDouble(holder.tvDoanhthuBaocao.getText().toString());
        double chiphi = Double.parseDouble(holder.tvChiphiBaocao.getText().toString());

        double lai = tongdoanhthu - chiphi;

        holder.tv_laixuat.setText(String.valueOf(lai));
    }

    @Override
    public int getItemCount() {
        return baoCaos.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{
        public ImageView imgBaocao;
        public TextView tvThoigianBaocao;
        public TextView tvDoanhthuBaocao;
        public TextView tvChiphiBaocao;
        public TextView tv_laixuat;
        public ImageView imgDeleteBaocao;


        public ViewHodel(View itemView) {
            super(itemView);
            imgBaocao = (ImageView) itemView.findViewById(R.id.img_baocao);
            tvThoigianBaocao = (TextView) itemView.findViewById(R.id.tv_thoigian_baocao);
            tvDoanhthuBaocao = (TextView) itemView.findViewById(R.id.tv_doanhthu_baocao);
            tvChiphiBaocao = (TextView) itemView.findViewById(R.id.tv_chiphi_baocao);
            imgDeleteBaocao = (ImageView) itemView.findViewById(R.id.img_delete_baocao);
            tv_laixuat = itemView.findViewById(R.id.tv_laixuat);
        }
    }
}
