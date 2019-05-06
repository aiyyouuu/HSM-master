package com.example.holiday.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataMemoDAO {
    @Insert
    Long insertData(DataMemo dataMemo);

    @Query("Select * from memo_db")
    List<DataMemo> getData();

    @Update
    int updateData(DataMemo item);

    @Delete
    void deleteData(DataMemo item);
}
