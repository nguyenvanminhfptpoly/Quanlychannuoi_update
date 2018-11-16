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
import com.example.admin88.quanlychannuoi.model.User;

import java.util.List;

public class Adapter_User extends RecyclerView.Adapter<Adapter_User.ViewHodel> {
    private List<User> users;
    private Context context;
    private OnitemDeleteDan  onitemDeleteDan;

    public Adapter_User(List<User> users, Context context, OnitemDeleteDan onitemDeleteDan) {
        this.users = users;
        this.context = context;
        this.onitemDeleteDan = onitemDeleteDan;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.item_user,parent,false);

        return new ViewHodel(v3, onitemDeleteDan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, final int position) {
            holder.tvAddress.setText(users.get(position).getmAddress());
            holder.tvUser.setText(users.get(position).getmName());
            holder.tvSdt.setText(users.get(position).getmSdt()+"");
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemDeleteDan.onItemdelete(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHodel extends RecyclerView.ViewHolder{
        public ImageView imgUser;
        public TextView tvUser;
        public TextView tvSdt;
        public TextView tvAddress;
        public ImageView imageView;

        public ViewHodel(View itemView,OnitemDeleteDan onitemDeleteDan) {
            super(itemView);
            imgUser = (ImageView) itemView.findViewById(R.id.img_user);
            tvUser = (TextView) itemView.findViewById(R.id.tv_user);
            tvSdt = (TextView) itemView.findViewById(R.id.tv_sdt);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
