package com.example.holiday.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.holiday.Model.HolidayItem;
import com.example.holiday.R;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.Holder>{
    private List<HolidayItem> holidayList;
    private Context context;
    public HolidayAdapter(Context context, List<HolidayItem> holidayList) {
        this.context = context;
        this.holidayList = holidayList;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_holiday, parent, false);
        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(HolidayAdapter.Holder holder, final int
            position) {
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return holidayList.size();
    }
    class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout openEdukasi;
        private TextView tvName;
        private TextView tvCountry;
        private TextView tvDate;
        private TextView tvPublic;

        public Holder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvPublic = itemView.findViewById(R.id.tv_public);
            openEdukasi = itemView.findViewById(R.id.openEdukasi);
        }

        public void bind(final int position) {
            tvName.setText(holidayList.get(position).getName());
            tvCountry.setText(holidayList.get(position).getCountry());
            tvDate.setText(holidayList.get(position).getDate());
            tvPublic.setText(holidayList.get(position).getPublicc());
            openEdukasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "clicked : " +
                                    tvName.getText().toString() + "\n Position : " + String.valueOf(position),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
