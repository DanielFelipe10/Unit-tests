package com.example.unit_tests;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Spinner spinner;
    private TextView showResult;
    private Button calculate;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        spinner = findViewById(R.id.spinnerC);
        showResult = findViewById(R.id.resultC);
        calculate = findViewById(R.id.buttonC);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.operations, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplay();
            }
        });
    }

    private void calculateAndDisplay() {
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        Calcs calc = new Calcs();

        String selectedOperation = spinner.getSelectedItem().toString();
        double result = 0.0;

        switch (selectedOperation) {
            case "Suma":
                result = calc.add(number1, number2);
                break;
            case "Resta":
                result = calc.subtract(number1, number2);
                break;
            case "Multiplicación":
                result = calc.multiply(number1, number2);
                break;
            case "División":
                result = calc.divide(number1, number2);
                break;
        }

        showResult.setText("Resultado: " + result);
    }
}
