package ru.evtukhov.android.monitoringapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PressureActivity extends AppCompatActivity {

    private TextView pressureTop; //поле для ввода верхнего давления
    private TextView pressureBottom; //поле для ввода нижнего давления
    private TextView pulse; //поле для ввода пульса
    private CheckBox tachycardia; //галка
    private Button save; //кнопка

    List<IndividualIndicators> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        initViews();
    }

    private void initViews(){
        pressureTop = findViewById(R.id.pressureTop);
        pressureBottom = findViewById(R.id.pressureBottom);
        pulse = findViewById(R.id.pulse);
        tachycardia = findViewById(R.id.tachycardia);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try{
                    list.add(new IndividualIndicators(Integer.valueOf(pressureTop.getText().toString()), Integer.valueOf(pressureBottom.getText().toString()), Integer.valueOf(pulse.getText().toString()), tachycardia.isChecked()));
                    Toast.makeText(PressureActivity.this,getString(R.string.app_textSuccessfully),Toast.LENGTH_LONG).show();
                }
                catch (Exception ex) {
                    Toast.makeText(PressureActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
