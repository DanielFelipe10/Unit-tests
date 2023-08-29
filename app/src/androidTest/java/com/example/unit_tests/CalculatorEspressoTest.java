package com.example.unit_tests;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Test;

public class CalculatorEspressoTest {

    public ActivityScenarioRule<Calculator> activityScenarioRule = new ActivityScenarioRule<>(Calculator.class);

    @Test
    public void testCalculation() {
        // Ingresar números en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.num1)).perform(ViewActions.typeText("5"));
        Espresso.onView(ViewMatchers.withId(R.id.num2)).perform(ViewActions.typeText("3"));

        // Seleccionar una opción en el Spinner
        Espresso.onView(ViewMatchers.withId(R.id.spinner)).perform(ViewActions.click());
        Espresso.onData(ViewMatchers.withText("Suma")).perform(ViewActions.click());

        // Hacer clic en el botón de cálculo
        Espresso.onView(ViewMatchers.withId(R.id.calculator)).perform(ViewActions.click());

        // Verificar el resultado en el EditText
        Espresso.onView(ViewMatchers.withId(R.id.resultC)).check(ViewAssertions.matches(ViewMatchers.withText("Resultado: 8.0")));
    }
}
