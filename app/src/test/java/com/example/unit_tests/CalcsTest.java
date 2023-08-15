package com.example.unit_tests;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CalcsTest extends TestCase {

        private Calcs calc;

        @Before
        public void setUp() {
            calc = new Calcs();
        }

        @Test
        public void testAdd() {
            double result = calc.add(5, 3);
            assertEquals(8, result, 0.0001);
        }

        @Test
        public void testSubtract() {
            double result = calc.subtract(10, 4);
            assertEquals(6, result, 0.0001);
        }

        @Test
        public void testMultiply() {
            double result = calc.multiply(2, 3);
            assertEquals(6, result, 0.0001);
        }

        @Test
        public void testDivide() {
            double result = calc.divide(10, 2);
            assertEquals(8, result, 0.0001);
        }

        @Test
        public void testDivideByZero() {
            assertThrows(ArithmeticException.class, () -> calc.divide(10.0, 0.0));
        }
}