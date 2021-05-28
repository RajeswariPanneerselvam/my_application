package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.adapter.NewDesignAdapter;

public class NewDesignActivity extends AppCompatActivity implements ItemClick {


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_design);
        recyclerView=findViewById(R.id.recycler_tutorial);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new NewDesignAdapter(NewDesignActivity.this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClicked() {
    startActivity(new Intent(getApplicationContext(),KotlinTutorial.class));
    }
}