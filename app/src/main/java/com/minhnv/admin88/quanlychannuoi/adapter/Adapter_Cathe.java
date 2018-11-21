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
import com.minhnv.admin88.quanlychannuoi.model.Cathe;

import java.util.List;

public class Adapter_Cathe extends RecyclerView.Adapter<Adapter_Cathe.ViewHodel> {
    private List<Cathe> cathes;
    private Context context;
    private OnitemDeleteDan onitemDeleteDan;

    public Adapter_Cathe(List<Cathe> cathes, Context context,OnitemDeleteDan onitemDeleteDan) {
        this.cathes = cathes;
        this.context = context;
        this.onitemDeleteDan = onitemDeleteDan;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.item_cathe,parent,false);
        return new ViewHodel(v3, onitemDeleteDan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
        holder.tvCannang.setText(cathes.get(position).getmCannang()+"");
        holder.tvGiong.setText(cathes.get(position).getmGiong());
        holder.tvSohieucathe.setText(cathes.get(position).getmSohieucathe());
        holder.tvSohieudan.setText(cathes.get(position).getmSohieudan());
        holder.tvTinhtrang.setText(cathes.get(position).getmTinhtranglon());
        holder.tvXuatchuong.setText(cathes.get(position).getmXuatchuong());
        holder.tvTenbenh.setText(cathes.get(position).getmTenbenh());
        holder.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemDeleteDan.onItemdelete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cathes.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{
        public TextView tvSohieucathe;
        public TextView tvSohieudan;
        public TextView tvCannang;
        public TextView tvGiong;
        public TextView tvTinhtrang;
        public TextView tvTenbenh;
        public TextView tvXuatchuong;
        public ImageView imageView3;
        public ViewHodel(View itemView, OnitemDeleteDan onitemDeleteDan) {
            super(itemView);
            tvSohieucathe = (TextView) itemView.findViewById(R.id.tv_sohieucathe);
            tvSohieudan = (TextView) itemView.findViewById(R.id.tv_sohieudan);
            tvCannang = (TextView) itemView.findViewById(R.id.tv_cannang);
            tvGiong = (TextView) itemView.findViewById(R.id.tv_giong);
            tvTinhtrang = (TextView) itemView.findViewById(R.id.tv_tinhtrang);
            tvTenbenh = (TextView) itemView.findViewById(R.id.tv_tenbenh);
            tvXuatchuong = (TextView) itemView.findViewById(R.id.tv_xuatchuong);
            imageView3 = (ImageView) itemView.findViewById(R.id.img_delete_cathe);

        }
    }



}
