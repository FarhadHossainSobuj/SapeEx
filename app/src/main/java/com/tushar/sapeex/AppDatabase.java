package com.tushar.sapeex;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {UserModel.class,ExpencessModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao dao();


}
