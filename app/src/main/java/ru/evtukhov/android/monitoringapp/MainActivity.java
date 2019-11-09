package ru.evtukhov.android.monitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView age;
    private Button save;
    private Button pressure;
    private Button health;

    Set<Profile> profileSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        name = findViewById(R.id.FIO);
        age = findViewById(R.id.age);
        save = findViewById(R.id.save);
        pressure = findViewById(R.id.pressureTop);
        health = findViewById(R.id.health);

        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    profileSet.add(new Profile(name.getText().toString(), Integer.valueOf(age.getText().toString())));
                    Toast.makeText(MainActivity.this,getString(R.string.app_textSuccessfully),Toast.LENGTH_LONG).show();
                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
