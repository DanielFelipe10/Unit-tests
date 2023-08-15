package com.example.unit_tests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Salary extends AppCompatActivity {
    private EditText salario;
    private Spinner spinner;
    private Button calc;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        salario = findViewById(R.id.salary);
        spinner = findViewById(R.id.spinner);
        calc = findViewById(R.id.calcularSalario);
        showResult = findViewById(R.id.showSalary);

        // Cargar los items del spinner desde el array de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.calculation_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        double salary = Double.parseDouble(salario.getText().toString());
        int calculationType = spinner.getSelectedItemPosition();

        SalaryCalculator calculator = new SalaryCalculator(salary);

        double result = 0.0;
        String resultText = "";

        switch (calculationType) {
            case 0:
                result = calculator.calculateDailySalary();
                resultText = "Salario diario: " + result;
                break;
            case 1:
                result = calculator.calculateHealthDiscount();
                resultText = "Descuento por salud: " + result;
                break;
            case 2:
                result = calculator.calculatePensionDiscount();
                resultText = "Descuento por pensión: " + result;
                break;
        }

        showResult.setText(resultText);
    }
}
