package com.example.unit_tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class SalaryCalculatorTest extends TestCase {
    private SalaryCalculator calculator;

    @Before
    public void setUp() {
        calculator = new SalaryCalculator(1000.0);
    }

    @Test
    public void testCalculateDailySalary() {
        double expected = 1000.0 / 30;
        double result = calculator.calculateDailySalary();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculateHealthDiscount() {
        double expected = 1000.0 * 0.04;
        double result = calculator.calculateHealthDiscount();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testCalculatePensionDiscount() {
        double expected = 1000.0 * 0.07;
        double result = calculator.calculatePensionDiscount();
        assertEquals(expected, result, 0.001);
    }
}