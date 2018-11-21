package com.minhnv.admin88.quanlychannuoi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.base.ChitietDanActivity;
import com.minhnv.admin88.quanlychannuoi.interface1.OnitemDeleteDan;
import com.minhnv.admin88.quanlychannuoi.model.Dan;
import com.minhnv.admin88.quanlychannuoi.sqlite.DanDAO;
import com.minhnv.admin88.quanlychannuoi.sqlite.ThucAnDAO;

import java.util.ArrayList;
import java.util.List;

public class Adapter_dan extends RecyclerView.Adapter<Adapter_dan.ViewHodel> {
    private List<Dan> dans;
    private Context context;
    private OnitemDeleteDan onitemDeleteDan;
    private ThucAnDAO thucAnDAO;
    private DanDAO danDAO;

    public Adapter_dan(List<Dan> dans, Context context, OnitemDeleteDan onitemDeleteDan) {
        this.dans = dans;
        this.context = context;
        this.onitemDeleteDan= onitemDeleteDan;

    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_dan,parent,false);
        return new ViewHodel(v,context,(ArrayList<Dan>) dans,onitemDeleteDan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
        thucAnDAO = new ThucAnDAO(context);
        danDAO = new DanDAO(context);
        holder.tv_sohieudan.setText(dans.get(position).getmSohieudan());
        holder.tv_soluongdan.setText(dans.get(position).getmSoluongdan()+"");
        holder.tv_tinhtrangdan.setText(dans.get(position).getmTinhTrang());
        holder.img_delete_dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemDeleteDan.onItemdelete(position);
            }
        });
        int soluong = Integer.parseInt(holder.tv_soluongdan.getText().toString());
        int kq = (soluong*10);
        holder.tv_thucandan.setText(String.valueOf(kq));

    }

    @Override
    public int getItemCount() {
        return dans.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView img_dan,img_delete_dan;
    public TextView tv_sohieudan,tv_tinhtrangdan,tv_thucandan,tv_soluongdan;
    ArrayList<Dan> dans = new ArrayList<>();
    private ThucAnDAO thucAnDAO;
    Context context;
        public ViewHodel(View itemView, Context context, ArrayList<Dan> dans1, OnitemDeleteDan onitemDeleteDan) {
            super(itemView);
            this.context = context;
            this.dans = dans1;
            itemView.setOnClickListener(this);

            img_dan = itemView.findViewById(R.id.img_dan);
            img_delete_dan = itemView.findViewById(R.id.img_deletedan);
            tv_sohieudan = itemView.findViewById(R.id.img_sohieudan);
            tv_tinhtrangdan = itemView.findViewById(R.id.tinhtrangdan);
            tv_thucandan = itemView.findViewById(R.id.luongcam_dan);
            tv_soluongdan = itemView.findViewById(R.id.tv_soluongdan);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Dan dan = this.dans.get(position);
            Intent intent = new Intent(this.context, ChitietDanActivity.class);
            intent.putExtra("sohieudan",dan.getmSohieudan());
            intent.putExtra("soluong",dan.getmSoluongdan()+"");
            intent.putExtra("tinhtrang",dan.getmTinhTrang());
            context.startActivity(intent);
        }
    }

}
