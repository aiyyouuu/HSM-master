package com.example.holiday.ui.main.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.holiday.R;
import com.example.holiday.entity.DataMemo;
import com.example.holiday.ui.main.MainContract;

import java.util.List;

public class MainAdapterDb extends RecyclerView.Adapter<MainAdapterDb.viewHolder> {
    Context context;
    List<DataMemo> list;
    MainContract.view view;

    public MainAdapterDb(Context context, List<DataMemo> list, MainContract.view view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView etJudul, etTanggal, etKeterangan, id;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            etJudul = itemView.findViewById(R.id.tv_item_judul);
            etTanggal = itemView.findViewById(R.id.tv_item_tanggal);
            etKeterangan = itemView.findViewById(R.id.tv_item_keterangan);
            id = itemView.findViewById(R.id.tv_item_nomor);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }

    @NonNull
    @Override
    public MainAdapterDb.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_memo, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MainAdapterDb.viewHolder holder, int position) {
        final DataMemo item = list.get(position);
        holder.etJudul.setText(item.getJudul());
        holder.etTanggal.setText(item.getTanggal());
        holder.etKeterangan.setText(item.getKeterangan());
        holder.id.setText(String.valueOf(item.getId()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
