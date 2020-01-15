package com.tushar.sapeex;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserModel user);

    @Query("SELECT * FROM users")
    List<UserModel> getAll();

}
