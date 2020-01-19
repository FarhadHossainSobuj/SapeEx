package com.tushar.sapeex;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {UserModel.class,ExpencessModel.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao dao();

    final static Migration Migration2=new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            database.execSQL("ALTER TABLE expence ADD date TEXT");

        }
    };


}
