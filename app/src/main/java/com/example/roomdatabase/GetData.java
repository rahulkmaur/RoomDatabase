package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.roomdatabase.Adapter.UserAdapter;

import java.util.concurrent.Executors;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        recyclerView=findViewById(R.id.recycleview);

        getData();

    }
    private void getData(){

        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter((new UserAdapter(getApplicationContext(),DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData())));
            }
        });


    }
}