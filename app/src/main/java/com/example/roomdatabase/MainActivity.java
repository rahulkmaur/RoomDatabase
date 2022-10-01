package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.EntityClass.UserModel;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText name, phone, address;
    Button save, getdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phoneno);
        address = findViewById(R.id.address);
        save = findViewById(R.id.button);
        getdata = findViewById(R.id.getData);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GetData.class));
            }
        });
    }
        private void saveData(){

            String name_txt=name.getText().toString().trim();
            String phone_txt=phone.getText().toString().trim();
            String address_txt=address.getText().toString().trim();

                UserModel model=new UserModel();

                model.setName(name_txt);
                model.setPhone(phone_txt);
                model.setAddress(address_txt);

           try {
               Executors.newCachedThreadPool().execute(new Runnable() {
                   @Override
                   public void run() {
                       DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);
                   }
               });
           }catch (Exception e){
               //Ignord
           }

                name.setText("");
                phone.setText("");
                address.setText("");
                Toast.makeText(this,"Data Successfully saved",Toast.LENGTH_LONG).show();
            }
        }