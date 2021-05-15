package com.example.areaconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText cm, m, km;
    Button button, clear;
    double centi;
    double meter;
    double kilometer;
    Double a1, a2, a3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = findViewById(R.id.cm);
        m = findViewById(R.id.m);
        km = findViewById(R.id.km);

        button = findViewById(R.id.button);
        clear = findViewById(R.id.clear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm.getText().toString().equals("") && m.getText().toString().equals("") && km.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill the all field", Toast.LENGTH_LONG).show();
                } else if (cm.getText().toString().length() > 0) {

                    a1 = Double.parseDouble(cm.getText().toString());
                    meter = a1 / 100;
                    m.setText(String.valueOf(meter + " m"));
                    kilometer = a1 / 100000;
                    km.setText(String.valueOf(kilometer + " km"));

                } else if (m.getText().toString().length() > 0) {
                    a2 = Double.parseDouble(m.getText().toString());
                    centi = a2 * 100;
                    cm.setText(String.valueOf(centi + " cm"));
                    kilometer = a2 / 10000;
                    km.setText(String.valueOf(kilometer + " km"));
                } else {
                    a3 = Double.parseDouble(km.getText().toString());
                    centi = a3 * 100000;
                    cm.setText(String.valueOf(centi + " cm"));
                    meter = a3 * 1000;
                    m.setText(String.valueOf(meter + " m"));

                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText("");
                m.setText("");
                km.setText("");
            }
        });
    }
}
