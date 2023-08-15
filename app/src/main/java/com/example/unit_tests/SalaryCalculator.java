package com.example.unit_tests;

public class SalaryCalculator {
    private double salary;

    public SalaryCalculator(double salary) {
        this.salary = salary;
    }

    public double calculateDailySalary() {
        return salary / 30;
    }

    public double calculateHealthDiscount() {
        return salary * 0.04;
    }

    public double calculatePensionDiscount() {
        return salary * 0.06;
    }
}

