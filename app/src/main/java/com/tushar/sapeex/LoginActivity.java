package com.tushar.sapeex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText ET_userName,ET_password;
    TextView registration;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_userName=findViewById(R.id.username);
        ET_password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        registration=findViewById(R.id.registration);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"information")
                .allowMainThreadQueries()
                .addMigrations(AppDatabase.Migration2)
                .build();

        final UserDao dao=db.dao();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ET_userName.getText().toString();
                String password=ET_password.getText().toString();
                UserModel userr=dao.checkLogin(name,password);
         try {

             if(userr.getName().equals(name)) {
                 Intent intent = new Intent(LoginActivity.this, ExpencessActivity.class);
                 startActivity(intent);
             }else {
                 Toast.makeText(getApplicationContext(),"Name And Password not match",Toast.LENGTH_SHORT).show();

             }
         }catch (Exception e){
             Log.d("User :", "No user");
             Toast.makeText(getApplicationContext(),"Name And Password not match",Toast.LENGTH_SHORT).show();
         }


            }
        });



        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.login_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"Contact ",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
