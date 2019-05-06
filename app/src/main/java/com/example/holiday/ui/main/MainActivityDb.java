package com.example.holiday.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.holiday.R;
import com.example.holiday.View.MenuActivity;
import com.example.holiday.entity.AppDatabase;
import com.example.holiday.entity.DataMemo;
import com.example.holiday.ui.main.holder.MainAdapterDb;

import java.util.List;

public class MainActivityDb extends AppCompatActivity implements MainContract.view {
    private AppDatabase appDatabase;
    private MainPresenterDb presenter;
    private MainAdapterDb adapter;

    private Button btnTambah, btnBack;
    private RecyclerView recyclerView;
    private EditText etJudul, etTanggal, etKeterangan;

    private boolean edit = false;
    private int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        appDatabase = AppDatabase.iniDb(getApplicationContext());

        btnTambah = findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(this);
        btnBack = findViewById(R.id.btn_kembali);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
        });
        etJudul = findViewById(R.id.et_judul);
        etTanggal = findViewById(R.id.et_tanggal);
        etKeterangan = findViewById(R.id.et_keterangan);
        recyclerView = findViewById(R.id.rc_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        presenter = new MainPresenterDb(this);
        presenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Berhasil menghapus data", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etJudul.setText("");
        etTanggal.setText("");
        etKeterangan.setText("");
        btnTambah.setText("submit");
    }

    @Override
    public void getData(List<DataMemo> list) {
        adapter = new MainAdapterDb(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void editData(DataMemo item) {
        etJudul.setText(item.getJudul());
        etTanggal.setText(item.getTanggal());
        etKeterangan.setText(item.getKeterangan());
        id = item.getId();
    }

    @Override
    public void deleteData(final DataMemo item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        presenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onClick(View view) {
        if(view == btnTambah){
            if(etJudul.getText().toString().equals("") || etTanggal.getText().toString().equals("") || etKeterangan.getText().toString().equals("")) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show();
            }
                if(!edit) presenter.insertData(etJudul.getText().toString(), etTanggal.getText().toString(), etKeterangan.getText().toString(), appDatabase);
                else{
                    presenter.editData(etJudul.getText().toString(), etTanggal.getText().toString(), etKeterangan.getText().toString(), id, appDatabase);
                    edit = false;
                }
                resetForm();

        }
    }
}
