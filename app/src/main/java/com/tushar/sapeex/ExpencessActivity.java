package com.tushar.sapeex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class ExpencessActivity extends AppCompatActivity {

    private  EditText ET_type,ET_ammount;
    private Button BT_savee;
    private List<ExpencessModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expencess);
        ET_type=findViewById(R.id.ET_type);
        ET_ammount=findViewById(R.id.ET_ammount);

        BT_savee=findViewById(R.id.BT_savee);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"information")
                .allowMainThreadQueries()
                .build();

        final UserDao dao=db.dao();



        BT_savee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type=ET_type.getText().toString();
                float amount=Float.valueOf(ET_ammount.getText().toString());

                ExpencessModel ex1=new ExpencessModel(type,amount);
                dao.insertExpence(ex1);

                list=dao.getExpencess();

                for(ExpencessModel data:list){
                    Log.d("Data :","COst Type : "+ data.getCost_type()+"\n"+"Amount :"+String.valueOf(data.getAmmoutn()));
                }

            }
        });
    }
}
