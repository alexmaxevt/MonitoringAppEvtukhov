package ru.evtukhov.android.monitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HealthActivity extends AppCompatActivity {

    private TextView weight;
    private TextView steps;
    private Button save;

    List<Vitals> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        initViews();
    }

    public void initViews() {
        weight = findViewById(R.id.weigth);
        steps = findViewById(R.id.steps);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    list.add(new Vitals(Double.parseDouble(weight.getText().toString()), Integer.parseInt(steps.getText().toString())));
                    Toast.makeText(HealthActivity.this,getString(R.string.app_textSuccessfully),Toast.LENGTH_LONG).show();
                }
                catch (Exception ex) {
                    Toast.makeText(HealthActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
