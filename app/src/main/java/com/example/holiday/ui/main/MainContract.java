package com.example.holiday.ui.main;

import android.view.View;

import com.example.holiday.entity.AppDatabase;
import com.example.holiday.entity.DataMemo;

import java.util.List;

public interface MainContract {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataMemo> list);
        void editData(DataMemo item);
        void deleteData(DataMemo item);
    }
    interface presenter{
        void insertData(String judul, String tanggal, String keterangan, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String judul, String tanggal, String keterangan, int id, AppDatabase database);
        void deleteData(DataMemo dataMemo, AppDatabase database);
    }
}
