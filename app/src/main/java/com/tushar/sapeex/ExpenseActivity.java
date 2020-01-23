package com.tushar.sapeex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ExpenseActivity extends AppCompatActivity {


    List<ExpencessModel> list;
    private RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        rc = findViewById(R.id.recycler);
        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"information")
                .allowMainThreadQueries().build();

        final UserDao dao=db.dao();

        list=dao.getExpencess();

        Log.d("size", "" + list.size());

        CustomAdapter adapter = new CustomAdapter(list);

        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));


    }
}
