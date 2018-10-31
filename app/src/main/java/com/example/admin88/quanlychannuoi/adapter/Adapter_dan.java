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
import com.example.admin88.quanlychannuoi.model.Dan;

import java.util.List;

public class Adapter_dan extends RecyclerView.Adapter<Adapter_dan.ViewHodel> {
    private List<Dan> dans;
    private Context context;

    public Adapter_dan(List<Dan> dans, Context context) {
        this.dans = dans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_dan,parent,false);
        return new ViewHodel(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.tv_sohieudan.setText(dans.get(position).getmSohieudan());
        holder.tv_soluongdan.setText(dans.get(position).getmSoluongdan()+"");
        holder.tv_tinhtrangdan.setText(dans.get(position).getmTinhTrang());

    }

    @Override
    public int getItemCount() {
        return dans.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{
    public ImageView img_dan;
    public TextView tv_sohieudan,tv_tinhtrangdan,tv_thucandan,tv_soluongdan;

        public ViewHodel(View itemView) {
            super(itemView);
            img_dan = itemView.findViewById(R.id.img_dan);
            tv_sohieudan = itemView.findViewById(R.id.img_sohieudan);
            tv_tinhtrangdan = itemView.findViewById(R.id.tinhtrangdan);
            tv_thucandan = itemView.findViewById(R.id.luongcam_dan);
            tv_soluongdan = itemView.findViewById(R.id.soluong_dan);
        }
    }

}
