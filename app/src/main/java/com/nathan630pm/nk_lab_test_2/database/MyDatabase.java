package com.nathan630pm.nk_lab_test_2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nathan630pm.nk_lab_test_2.database.dao.MemberDao;
import com.nathan630pm.nk_lab_test_2.database.model.Member;

@Database(entities = {Member.class}, version = 3, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase db;
    public abstract MemberDao memberDao();

    public static MyDatabase getDatabase(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "dbRoom")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }

}
