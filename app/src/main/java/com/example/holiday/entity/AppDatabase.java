package com.example.holiday.entity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {DataMemo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataMemoDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,
                    "dbMemo").allowMainThreadQueries().build();

        return appDatabase;
    }

    public static void destroyInstance(){ appDatabase = null;}
}
