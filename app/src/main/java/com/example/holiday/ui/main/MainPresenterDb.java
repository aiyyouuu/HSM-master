package com.example.holiday.ui.main;

import android.os.AsyncTask;
import android.util.Log;

import com.example.holiday.entity.AppDatabase;
import com.example.holiday.entity.DataMemo;

import java.util.List;

public class MainPresenterDb implements MainContract.presenter {
    private MainContract.view view;

    public MainPresenterDb(MainContract.view view){ this.view = view; }

    class InsertData extends AsyncTask<Void, Void, Long>{
        private AppDatabase database;
        private DataMemo dataMemo;

        public InsertData(AppDatabase database, DataMemo dataMemo){
            this.database = database;
            this.dataMemo = dataMemo;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataMemo);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            view.successAdd();
        }
    }
    @Override
    public void insertData(String judul, String tanggal, String keterangan,
                           final AppDatabase database) {
        final DataMemo dataMemo = new DataMemo();
        dataMemo.setJudul(judul);
        dataMemo.setTanggal(tanggal);
        dataMemo.setKeterangan(keterangan);
        new InsertData(database, dataMemo).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataMemo dataMemo;

        public EditData(AppDatabase database, DataMemo dataMemo) {
            this.database = database;
            this.dataMemo = dataMemo;
        }
        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataMemo);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String judul, String tanggal, String keterangan, int id,
                         final AppDatabase database) {
        final DataMemo dataMemo = new DataMemo();
        dataMemo.setJudul(judul);
        dataMemo.setTanggal(tanggal);
        dataMemo.setKeterangan(keterangan);
        dataMemo.setId(id);

        new EditData(database, dataMemo).execute();
    }

    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataMemo dataMemo;

        public DeleteData(AppDatabase database, DataMemo dataMemo) {
            this.database = database;
            this.dataMemo = dataMemo;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataMemo);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(final DataMemo dataMemo,
                           final AppDatabase database) {
        new DeleteData(database, dataMemo).execute();
    }
}
