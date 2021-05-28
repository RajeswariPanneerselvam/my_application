package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.opengl.GLDebugHelper;
import android.os.Bundle;

import com.example.myapplication.adapter.NewDesignAdapter;
import com.example.myapplication.adapter.TutorialAdapter;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView=findViewById(R.id.recycler_tutorial1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new TutorialAdapter(MainActivity2.this));
        recyclerView.setHasFixedSize(true);



    }
}