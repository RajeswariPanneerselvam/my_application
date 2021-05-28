package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.database.DbHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataBaseActivity extends AppCompatActivity {


    @BindView(R.id.edit_name1)
    EditText edit_name;
    @BindView(R.id.edit_location)
    EditText edit_location;
    @BindView(R.id.edit_destination)
    EditText edit_destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);


        ButterKnife.bind(this);


    }
        @OnClick(R.id.saveBtn)
                public void saveDB(View view){




                String username = edit_name.getText().toString()+"\n";
                String location = edit_location.getText().toString();
                String designation = edit_destination.getText().toString();
                DbHandler dbHandler = new DbHandler(DataBaseActivity.this);
                dbHandler.insertUserDetails(username,location,designation);
               Intent intent = new Intent(DataBaseActivity.this,DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();






    }
}