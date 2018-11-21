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
import com.minhnv.admin88.quanlychannuoi.model.HoaDon;
import com.minhnv.admin88.quanlychannuoi.sqlite.HoadonDAO;

import java.text.DecimalFormat;
import java.util.List;

public class Adapter_Hoadon extends RecyclerView.Adapter<Adapter_Hoadon.ViewHodel> {
    private List<HoaDon> hoaDons;
    private Context context;
    private OnitemDeleteDan onitemDeleteDan;
    private HoadonDAO hoadonDAO;
    private DecimalFormat decimalFormat;

    public Adapter_Hoadon(List<HoaDon> hoaDons, Context context,OnitemDeleteDan onitemDeleteDan) {
        this.hoaDons = hoaDons;
        this.context = context;
        this.onitemDeleteDan = onitemDeleteDan;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.item_hoadon,parent,false);
        return new ViewHodel(v3,onitemDeleteDan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
        hoadonDAO = new HoadonDAO(context);
        holder.tvGiathitlonHoadon.setText(hoaDons.get(position).getmGiaThitLon()+"");
        holder.tvSoluongHoadon.setText(hoaDons.get(position).getmSoluongHoadon()+"");
        holder.tvMahoadon.setText(hoaDons.get(position).getmMahoadon());

        holder.tvTendanHoadon.setText(hoaDons.get(position).getmTenDan_hoadon());
        holder.imgDeleteHoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemDeleteDan.onItemdelete(position);
            }
        });
        int soluong = Integer.parseInt(holder.tvSoluongHoadon.getText().toString());
        double gia = Double.parseDouble((holder.tvGiathitlonHoadon.getText().toString()));
        double thanhtien = soluong * gia;
        holder.tvThanhtienHoadon.setText(String.valueOf(thanhtien));


    }

    @Override
    public int getItemCount() {
        return hoaDons.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{
        public ImageView imgHoadon;
        public TextView tvMahoadon;
        public TextView tvTendanHoadon;
        public TextView tvSoluongHoadon;
        public TextView tvGiathitlonHoadon;
        public TextView tvThanhtienHoadon;
        public ImageView imgDeleteHoadon;

        public ViewHodel(View itemView,OnitemDeleteDan onitemDeleteDan) {
            super(itemView);
            imgHoadon = (ImageView) itemView.findViewById(R.id.img_hoadon);
            tvMahoadon = (TextView) itemView.findViewById(R.id.tv_mahoadon);
            tvTendanHoadon = (TextView) itemView.findViewById(R.id.tv_tendan_hoadon);
            tvSoluongHoadon = (TextView) itemView.findViewById(R.id.tv_soluong_hoadon);
            tvGiathitlonHoadon = (TextView) itemView.findViewById(R.id.tv_giathitlon_hoadon);
            tvThanhtienHoadon = (TextView) itemView.findViewById(R.id.tv_thanhtien_hoadon);
            imgDeleteHoadon = (ImageView) itemView.findViewById(R.id.img_delete_hoadon);

        }
    }
}
