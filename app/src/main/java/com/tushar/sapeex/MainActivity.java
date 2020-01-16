package com.tushar.sapeex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText ET_name,ET_number,ET_date;
    Button BT_save;
    List<UserModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_name=findViewById(R.id.ET_name);
        BT_save=findViewById(R.id.BT_save);
        ET_date=findViewById(R.id.ET_date);


        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"information")
                .allowMainThreadQueries().build();

        final UserDao dao=db.dao();



        BT_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ET_name.getText().toString();

                UserModel user1=new UserModel(name,"123456");
                dao.insert(user1);
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();



                list=new ArrayList<>();


                list=dao.getAll();


                for(UserModel data:list){
                    Log.d("Data", data.getName());
                }
            }
        });


        ET_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }





}
