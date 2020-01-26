package com.tushar.sapeex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class ExpencessActivity extends AppCompatActivity {

    private  EditText ET_type,ET_ammount,ET_date;
    private Button BT_savee,BT_show;
    private List<ExpencessModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expencess);
        ET_type=findViewById(R.id.ET_type);
        ET_ammount=findViewById(R.id.ET_ammount);
        ET_date=findViewById(R.id.ET_Date);

        BT_savee=findViewById(R.id.BT_savee);
        BT_show=findViewById(R.id.BT_show);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"information")
                .allowMainThreadQueries()
                .addMigrations(AppDatabase.Migration2)
                .build();

        final UserDao dao=db.dao();



        BT_savee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type=ET_type.getText().toString();
                String date=ET_date.getText().toString();
                float amount=Float.valueOf(ET_ammount.getText().toString());


                ExpencessModel ex1=new ExpencessModel(type,amount,date);
                dao.insertExpence(ex1);

                list=dao.getExpencess();

                for(ExpencessModel data:list){
                    Log.d("Data :","Cost Type : "+ data.getCost_type()+"\n"+"Amount :"+String.valueOf(data.getAmmoutn()));
                }
                //hi

            }
        });

        ET_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateChose();
            }
        });


        BT_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ExpencessActivity.this,ExpenseActivity.class);
                startActivity(intent);
            }
        });
    }


    //Method for Date Picker......................................................
    void dateChose(){
        Calendar c=Calendar.getInstance();

        DatePickerDialog datePick=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              //  Toast.makeText(getApplicationContext(), String.valueOf(year),Toast.LENGTH_SHORT);

                String date=String.valueOf(dayOfMonth)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year);
                ET_date.setText(date);

            }
        },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));

        datePick.show();
    }
}
