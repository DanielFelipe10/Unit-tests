package com.example.unit_tests;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorEspressoTest {

    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void setup() {
        Intents.init(); // Inicializar Intents para capturar intenciones
    }
    @After
    public void teardown() {
        Intents.release(); // Liberar Intents después de las pruebas
    }

    @Test
    public void testCalculation() {
        // Realizar clic en el botón Calculadora
        Espresso.onView(ViewMatchers.withId(R.id.calculator)).perform(ViewActions.click());

        // Ingresar números en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.num1)).perform(ViewActions.typeText("5"));
        Espresso.onView(ViewMatchers.withId(R.id.num2)).perform(ViewActions.typeText("3"));

        // Seleccionar una opción en el Spinner
        Espresso.onView(ViewMatchers.withId(R.id.spinnerC)).perform(ViewActions.click());
        Espresso.onData(ViewMatchers.withText("Suma")).perform(ViewActions.click());

        // Hacer clic en el botón de cálculo
        Espresso.onView(ViewMatchers.withId(R.id.calculator)).perform(ViewActions.click());

        // Verificar el resultado en el EditText
        Espresso.onView(ViewMatchers.withId(R.id.resultC)).check(ViewAssertions.matches(ViewMatchers.withText("Resultado: 8.0")));
    }
}
