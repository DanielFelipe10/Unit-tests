package com.example.unit_tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calculadora, salario, mas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculadora = findViewById(R.id.calculator);
        salario = findViewById(R.id.salary);
        mas = findViewById(R.id.more);

        //Button CALCULADORA
        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSuma = new Intent(MainActivity.this, Calculator.class);
                startActivity(intentSuma);
            }
        });

        //Button SALARIO
        salario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResta = new Intent(MainActivity.this, Salary.class);
                startActivity(intentResta);
            }
        });
    }
}