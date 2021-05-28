package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.database.DbHandler;

public class DisplayContactActivity extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    private DbHandler mydb ;
    int id_To_Update = 0;
    Button saveContact;
    EditText email, street, phone, place, name;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);



    }
}

