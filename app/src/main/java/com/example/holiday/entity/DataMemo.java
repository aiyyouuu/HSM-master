package com.example.holiday.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "memo_db")
public class DataMemo {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getJudul() { return judul; }

    public void setJudul(String judul) { this.judul = judul; }

    public String getTanggal() { return tanggal; }

    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getKeterangan() { return keterangan; }

    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
}
